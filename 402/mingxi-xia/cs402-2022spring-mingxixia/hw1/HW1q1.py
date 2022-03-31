from collections import Counter
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

tex_url = "http://www.cs.iit.edu/~virgil/cs470/varia/traces/benchmarks/tex.din"
spice_url = "http://www.cs.iit.edu/~virgil/cs470/varia/traces/benchmarks/spice.din"

def read_data(url,limit):
    data = pd.read_table(url, sep=' ', names=['number', 'address'])[:limit] # get number and address data from url respectively 
    data['address'] = [str(int(i,16)) for i in data['address']]    
    return data
def draw_hist(url,limit):
    data = read_data(url,limit)
    address_list = list(set(data['address']))
    df = pd.DataFrame(np.zeros(len(address_list),int),index = address_list,columns=["counts"])

    for j in address_list:
        for i in data['address']:
            if str(i) == str(j):
                df.loc[j,'counts'] += 1     

    df.plot.bar()
    plt.title('Address Frequency of spice.din')
    plt.xlabel('address')
    plt.ylabel('counts')
    plt.xticks(rotation = 90)
    plt.show()    
    
draw_hist(tex_url,200)
draw_hist(spice_url,200)

#read 0, write 1, instruction fetch 2
def data_count(url,limit):
    data = read_data(url,limit)
    counts = data['number'].value_counts().to_dict()
    return print(counts)

print("The frequency of values in tex.din file:\n0-read\n1-write\n2-instruction fetch")
data_count(tex_url,None)
print("The frequency of values in spice.din file:\n0-read\n1-write\n2-instruction fetch")
data_count(spice_url,None)

