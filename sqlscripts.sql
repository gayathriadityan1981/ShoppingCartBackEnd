INSERT INTO `user` (`id`, `address1`, `address2`, `city`, `name`, `password`, `role`, `username`) VALUES ('1', 'address1', 'address2', 'coimbatore', 'gayathri', 'dharsan1', 'user', 'gayathri@gmail.com');
INSERT INTO `user` (`id`, `address1`, `address2`, `city`, `name`, `password`, `role`, `username`) VALUES ('2', 'address1', 'address2', 'chennai', 'dharsan', 'dharsan1', 'user', 'dharsan@gmail.com');

INSERT INTO `cart` (`cart_id`, `total_price`, `customer_id`) VALUES ('1', '19000', '1');
INSERT INTO `cart` (`cart_id`, `total_price`, `customer_id`) VALUES ('2', '17890', '2');

INSERT INTO `customer` (`customer_id`, `city`, `customer_phone`, `first_name`, `gender`, `last_name`, `shipping_address`, `state_id`, `cart_id`, `user_id`) VALUES ('1', 'coimbatore', '453543', 'gayathri', 'female', 'adityan', 'coimbatore', 1, '1', '1');
INSERT INTO `customer` (`customer_id`, `city`, `customer_phone`, `first_name`, `gender`, `last_name`, `shipping_address`, `state_id`, `cart_id`, `user_id`) VALUES ('2', 'coimbatore', '453543', 'dharsan', 'male', 'dharsan', 'coimbatore', 2, '2', '2');

INSERT INTO `customer_order` (`customer_order_id`, `cart_id`, `customer_id`) VALUES ('1', '1', '1');
INSERT INTO `customer_order` (`customer_order_id`, `cart_id`, `customer_id`) VALUES ('2', '2', '2');

INSERT INTO `state` (`state_id`, `abbreviation`, `name`) VALUES ('1', 'TN', 'TamilNadu'), ('2', 'KL', 'Kerala');

insert into customer_order(customer_order_id,item_cost,product_name,cart_id,customer_id)
values(2,3000,'panasonic',2,2);



