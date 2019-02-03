
# coding: utf-8

# In[ ]:

import pandas as pd
import xmltodict
import os
import sys
import json
from elasticsearch import Elasticsearch

es = Elasticsearch([{'host': 'localhost', 'port': 9200}])

chunck_result = []
query = sys.argv[1]
res = es.search(index='ct', body={
                                          "query":
                                                 {"bool":
                                                        {"must":
                                                               {"multi_match":
                                                                      {"query":query,"type":"phrase_prefix", "fields":["brief_title","brief_summary","detailed_description","condition", "eligibility","keyword","mesh_term"]
                                                                      }
                                                               },
                                                         "should":
                                                                [
                                                                 {"term":{"eligibility" : "query"}},
                                                                 {"term":{"brief_summary" : "query"}},
                                                                 {"term":{"detailed_description" : "query"}},
                                                                 {"term":{"keyword" : "query"}},
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
# print(" response: '%s'" % (res))
for hit in res['hits']['hits']:
    chunck_result.append(hit["_source"])

f=open("abc_divya.json",'w', encoding="utf-8")
json.dump(chunck_result,f)
f.close()