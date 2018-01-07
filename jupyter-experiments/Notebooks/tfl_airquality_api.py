import requests
import json


rls = requests.get("http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json")

r = rls.json()

list_of_sites = []

for x in r['Sites']['Site']:

    site_info = {}

    site_info['SiteName'] = x['@SiteName']
    site_info['Latitude'] = x['@Latitude']
    site_info['Longitude'] = x['@Longitude']
    site_info['SiteCode'] = x['@SiteCode']

    list_of_sites.append(site_info)

print("Finished making list of sites, total..", len(list_of_sites))

limit = 200
skipped = 0
for x in list_of_sites:
    if(limit < 0):
        break

    url = "http://api.erg.kcl.ac.uk/AirQuality/Annual/MonitoringReport/SiteCode={}/Year=2015/Json".format(x['SiteCode'])
    tls = requests.get(url)

    r = []
    try:

        r = tls.json()

    except:

        print("Something went wrong")

    if(len(r) is 0):
        continue


    if(r['SiteReport'] is None):
        skipped += 1
        print("Skipped... ",skipped)
        continue



    x['num_of_low_days_no2'] = -1

    for y in r['SiteReport']['ReportItem']:


        #print(y)

        if(y['@ReportItemName'] == 'Low days:' and y['@SpeciesCode'] == 'NO2'):
            x['num_of_low_days_no2'] = y['@Annual']
            print(x['num_of_low_days_no2'])
            limit -= 1
            break


with open('../datasets/site_info.json', 'w') as outfile:
    json.dump(list_of_sites, outfile)
