org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'PUT'
    url '/heroes'
    body('''
    {
      "id":"3",
      "name":"Clara"
    }
    ''')
    headers {
      header('Content-Type', 'application/json')
    }
  }
response {
  status 200
  
 }
}