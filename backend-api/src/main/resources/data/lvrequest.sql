INSERT INTO `hourlogix`.`leave_request`
(`avaialable_lv`, `hours_of_lv_requested`, `employee_id`, `leave_request_id`, `lv_end_date`, `lv_start_date`, `reason`, `status`, `typeof_lv`)
VALUES
(15, 8, 1, 101, '2024-07-01', '2024-06-25', 'Family emergency', 'Pending', 'Sick Leave'),
(12, 5, 2, 102, '2024-08-10', '2024-08-05', 'Medical appointment', 'Approved', 'Annual Leave'),
(20, 10, 3, 103, '2024-09-15', '2024-09-05', 'Vacation', 'Approved', 'Annual Leave'),
(18, 7, 4, 104, '2024-10-05', '2024-09-28', 'Personal reasons', 'Pending', 'Sick Leave'),
(16, 8, 5, 105, '2024-11-20', '2024-11-10', 'Child care', 'Rejected', 'Sick Leave'),
(14, 6, 6, 106, '2024-12-25', '2024-12-19', 'Holiday', 'Denied', 'Annual Leave'),
(12, 4, 7, 107, '2024-06-30', '2024-06-26', 'Medical emergency', 'Pending', 'Sick Leave'),
(10, 5, 8, 108, '2024-07-15', '2024-07-10', 'Family event', 'Approved', 'Annual Leave'),
(22, 12, 9, 109, '2024-08-25', '2024-08-15', 'Extended vacation', 'Approved', 'Annual Leave'),
(20, 9, 10, 110, '2024-09-30', '2024-09-21', 'Moving house', 'Denied', 'Sick Leave');
