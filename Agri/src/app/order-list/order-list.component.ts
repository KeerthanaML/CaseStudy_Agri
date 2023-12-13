import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order.service';  // Make sure the path is correct based on your folder structure.

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders: any[] = [];

  constructor(private orderService: OrderService, private router: Router) { }

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders(): void {
    this.orderService.getAllOrders().subscribe(
      data => this.orders = data,
      error => console.error('Error fetching orders', error)
    );
  }

  

  deleteOrder(orderId: string): void {
    if (confirm('Are you sure you want to delete this order?')) {
      this.orderService.deleteOrder(orderId).subscribe(
        () => {
          console.log('Successfully deleted order');
          alert('Order deleted successfully');
          this.loadOrders();  // Refresh the order list
        },
        (        error: any) => console.error('Error deleting order', error)
      );
    }
  }

}
