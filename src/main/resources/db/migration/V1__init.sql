CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL,
    `first_name` varchar(80) NOT NULL,
    `last_name` varchar(80) NOT NULL,
    `gender` varchar(6) NOT NULL,
    `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
ALTER TABLE `person` ADD PRIMARY KEY (`id`);
ALTER TABLE `person` MODIFY `id` bigint NOT NULL AUTO_INCREMENT;