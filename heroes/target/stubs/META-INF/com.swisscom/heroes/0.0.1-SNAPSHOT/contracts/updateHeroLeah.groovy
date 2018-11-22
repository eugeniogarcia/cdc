org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'POST'
    url '/heroes'
    body('''
    {
      "id":"2",
      "name":"Leah"
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