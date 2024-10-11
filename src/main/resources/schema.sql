CREATE TABLE IF NOT EXISTS cpuMetrics(
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestap TIMESTAMP,
    cpuName varchar(255),
    coreCount INT,
    loadPercentage DOUBLE,
    temp DOUBLE
);

