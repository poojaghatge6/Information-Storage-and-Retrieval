from elasticsearch import Elasticsearch 
import os 
import sys
query = sys.argv[1]
es = Elasticsearch([{'host': 'localhost', 'port': 9200}])
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
                                   size=1000
                     )['hits']['hits']
max_score = res[0]['_score']
rank_ctr = 1
op=open("result.txt", "w")
op.write(str(res))
op.close() 
