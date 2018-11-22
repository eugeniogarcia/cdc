org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'GET'
    url '/heroes/3'
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 200
    body('''
    {
      "id":"3",
      "name":"Mausi"
    }
    ''')
  headers {
    header('Content-Type': 'application/json;charset=UTF-8')
  }
 }
}