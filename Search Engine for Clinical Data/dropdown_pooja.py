
# coding: utf-8

# In[ ]:

import pandas as pd
import xmltodict
import os
import sys
import json
from elasticsearch import Elasticsearch

es = Elasticsearch([{'host': 'localhost', 'port': 9200}])
disease=sys.argv[1]
gene_name=sys.argv[3].split()[0]
none=sys.argv[2]
query=disease+" "+gene_name
chunck_result = []
res = es.search(index = "_all", doc_type="", body={
        'query':{
            'multi_match':{
                'query': query,
                "fields": ["title^2","abstract"],
                "fuzziness":"AUTO"   
            }   
        }
    },size=100)
# print(" response: '%s'" % (res))
for hit in res['hits']['hits']:
    chunck_result.append(hit["_source"])

f=open("abc_dropdown.json",'w', encoding="utf-8")
json.dump(chunck_result,f)
f.close()