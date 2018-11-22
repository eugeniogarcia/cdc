org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'POST'
    url '/heroes'
    body('''
    {
      "name":"Eugenio"
    }
    ''')
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 200
    body('''
    {
      "id":"6",
      "name":"Eugenio"
    }
    ''')
  headers {
    header('Content-Type': 'application/json;charset=UTF-8')
  }
 }
}