
import xml.etree.ElementTree as ET
import collections
from elasticsearch import Elasticsearch
import sys
import json

es = Elasticsearch([{'host': 'localhost', 'port': 9200}])
query1=sys.argv[1]
query2=sys.argv[2]
query3=sys.argv[3]
chunck_result=[]
#query1="acute myeloid leukemia"
print(query1)
res = es.search(index='ct', body={
                                          "query":
                                                 {"bool":
                                                        {"must":
                                                               [{"multi_match":
                                                                      {"query":query1,"type":"phrase_prefix", "fields":["brief_title","brief_summary","detailed_description","condition", "eligibility","keyword","mesh_term"]
                                                                      }
                                                               },
                                                                
                                                                 #{"term":{"eligibility" : "query"}},
                                                                 {"match":{"brief_summary" : query1}},
                                                                 {"term":{"minimum_age" : 15}},
                                                                 
                                                                 #{"term":{"keyword" : "query"}},
                                                                ]
                                                        }
                                                 },
                                          "post_filter":
                                                 {"term":
                                                        {"gender":"all"}
                                                 }
                                          },
                                   size=100
                     )

for hit in res['hits']['hits']:
    chunck_result.append(hit["_source"])

f=open("drop_divya.json",'w', encoding="utf-8")
json.dump(chunck_result,f)
f.close()





