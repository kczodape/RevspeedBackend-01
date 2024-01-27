package com.coderdot.services;

import com.coderdot.entities.Customer;

public interface CustomerRoleUpdateServicer {
    Customer updateCustomerRole(Long customerId, String newRole);
}
