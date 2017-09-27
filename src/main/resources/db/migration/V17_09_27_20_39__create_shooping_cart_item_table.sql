CREATE TABLE `t_shopping_cart_item` (
  `shopping_cart_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `FKkh6hqovynj0gq4fc2hl1wj789` (`item_id`),
  KEY `FKksuv5rq4x0jpam0u61ukxgw2v` (`shopping_cart_id`),
  CONSTRAINT `FKkh6hqovynj0gq4fc2hl1wj789` FOREIGN KEY (`item_id`) REFERENCES `t_item` (`id`),
  CONSTRAINT `FKksuv5rq4x0jpam0u61ukxgw2v` FOREIGN KEY (`shopping_cart_id`) REFERENCES `t_shopping_carts` (`id`)
)