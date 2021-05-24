INTUIT CRAFT

Intuit supports below products for Small Business owners:

1. Quickbooks (QB) for Accounting
2. QB Payroll for paying small business employees
3. QB Payments for small business to receive payments from their customers
4. TSheets for time-tracking
Customers can subscribe to any/all of the above products and by doing so, maintain business profile across all of the products.


intuit-service as main project that client would request for creation & updation of business profile.
4 different sub projects to maintain business profile for a customer.
  1.  quickbook-accounting
  2.  quickbook-payroll
  3.  quickbook-payment
  4.  quickbook-tsheet
Each project would be used to validate business profile for a particular customer (dummy validation)

SWAGGER
http://localhost:8080/swagger-ui.html#/intuit-service-controller
http://localhost:8002/swagger-ui.html#/accounting-controller
http://localhost:8003/swagger-ui.html#/payment-controller
http://localhost:8004/swagger-ui.html#/payroll-controller
http://localhost:8005/swagger-ui.html#/tsheet-controller



POSSIBLE ENHANCEMENT
1.  Caching mechanism should be introduced for timeout validation by product.
2.  Service-discovery to locate/discover the url's for different service for rest based calls.
3.  Validation currently handling for company legalname