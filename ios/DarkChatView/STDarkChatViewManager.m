//
//  STDarkChatViewManager.m
//  RNDarkChatView
//
//  Created by 石破天 on 2019/1/21.
//  Copyright © 2019年 Facebook. All rights reserved.
//

#import "STDarkChatViewManager.h"
#import "STDarkChatView.h"
#import <React/RCTBridge.h>
#import <React/RCTUIManager.h>

@interface RCTBridge ()
- (RCTUIManager *)uiManager;
@end

@implementation STDarkChatViewManager

RCT_EXPORT_MODULE(DarkChatView)
RCT_EXPORT_VIEW_PROPERTY(refreshHeaderHeight, float)
RCT_EXPORT_VIEW_PROPERTY(loadingFooterHeight, float)
RCT_EXPORT_VIEW_PROPERTY(initialContentOffset, id)
RCT_EXPORT_VIEW_PROPERTY(allLoaded, BOOL)

- (UIView *)view
{
    return [[STDarkChatView alloc] initWithEventDispatcher:self.bridge.eventDispatcher];
}

RCT_EXPORT_METHOD(endRefresh:(nonnull NSNumber *)reactTag){
    [self.bridge.uiManager addUIBlock:
     ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, __kindof UIView *> *viewRegistry){
         STDarkChatView *view = viewRegistry[reactTag];
         [view endRefresh];
     }];
}

RCT_EXPORT_METHOD(endLoading:(nonnull NSNumber *)reactTag){
    [self.bridge.uiManager addUIBlock:
     ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, __kindof UIView *> *viewRegistry){
         STDarkChatView *view = viewRegistry[reactTag];
         [view endLoading];
     }];
}

RCT_EXPORT_METHOD(scrollTo:(nonnull NSNumber *)reactTag offsetX:(CGFloat)offsetX offsetY:(CGFloat)offsetY animated:(BOOL) animated){
    [self.bridge.uiManager addUIBlock:
     ^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, __kindof UIView *> *viewRegistry){
         STDarkChatView *view = viewRegistry[reactTag];
         [view.scrollView setContentOffset:CGPointMake(offsetX, offsetY) animated:animated];
     }];
}

@end




