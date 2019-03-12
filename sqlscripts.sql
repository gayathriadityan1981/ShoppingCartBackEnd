INSERT INTO `user` (`id`, `address1`, `address2`, `city`, `name`, `password`, `role`, `username`) VALUES ('1', 'address1', 'address2', 'coimbatore', 'gayathri', 'dharsan1', 'user', 'gayathri@gmail.com');

INSERT INTO `cart` (`cart_id`, `total_price`, `customer_id`) VALUES ('1', '19000', '1');

INSERT INTO `customer` (`customer_id`, `city`, `customer_phone`, `first_name`, `gender`, `last_name`, `shipping_address`, `state`, `cart_id`, `user_id`) VALUES ('1', 'coimbatore', '453543', 'gayathri', 'female', 'adityan', 'coimbatore', 'tamilnadu', '1', '1');

INSERT INTO `customer_order` (`customer_order_id`, `cart_id`, `customer_id`) VALUES ('1', '1', '1');


