CREATE TABLE `t_order_item` (
  `order_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `FKq6cu0j50hhxmelgkni3v5s34l` (`item_id`),
  KEY `FK2y83rerik30vumt2a1mff6606` (`order_id`),
  CONSTRAINT `FK2y83rerik30vumt2a1mff6606` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FKq6cu0j50hhxmelgkni3v5s34l` FOREIGN KEY (`item_id`) REFERENCES `t_item` (`id`)
)