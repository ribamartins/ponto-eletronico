CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `update_date` datetime NOT NULL,
  `creation_date` datetime NOT NULL,
  `razao_social` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employer` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `update_date` datetime NOT NULL,
  `creation_date` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `profile` varchar(255) NOT NULL,
  `cnt_hour_lunch` float DEFAULT NULL,
  `cnt_hour_work` float DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `hour_value` decimal(19,2) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `entry` (
  `id` bigint(20) NOT NULL,
  `data` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `creation_date` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `localization` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `employer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `empresa`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `employer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4cm1kg523jlopyexjbmi6y54j` (`company_id`);

--
-- Indexes for table `lancamento`
--
ALTER TABLE `entry`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK46i4k5vl8wah7feutye9kbpi4` (`employer_id`);

--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `company`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `employer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lancamento`
--
ALTER TABLE `entry`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `funcionario`
--
ALTER TABLE `employer`
  ADD CONSTRAINT `FK4cm1kg523jlopyexjbmi6y54j` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `lancamento`
--
ALTER TABLE `entry`
  ADD CONSTRAINT `FK46i4k5vl8wah7feutye9kbpi4` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`);