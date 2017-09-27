CREATE TABLE `t_shopping_carts` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgi7axyi3rkcyp7n5gvnfx3w9e` (`user_id`),
  CONSTRAINT `FKgi7axyi3rkcyp7n5gvnfx3w9e` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
)