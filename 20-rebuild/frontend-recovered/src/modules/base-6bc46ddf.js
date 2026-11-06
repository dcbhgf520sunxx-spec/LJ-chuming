import { l as e } from "../shared/runtime.js";
function i() {
  return e({ url: "api/config/mes/overweightSMSRecipient", method: "get" });
}
function o(t) {
  return e({ url: "api/config/mes/overweightSMSRecipient", method: "put", data: t });
}
function r() {
  return e({ url: "api/config/safety/factor", method: "get" });
}
function u({ safetyFactor: t }) {
  return e({ url: "api/config/safety/factor", method: "put", data: { safetyFactor: t } });
}
function g() {
  return e({ url: "/api/config/driver", method: "get" });
}
function a(t) {
  return e({ url: "/api/config/driver", method: "put", data: t });
}
function f() {
  return e({ url: "/api/drawing/rules", method: "get" });
}
function s(t) {
  return e({ url: "/api/drawing/rules", method: "post", data: t });
}
function c() {
  return e({ url: "/api/config/print", method: "get" });
}
function l(t) {
  return e({ url: "/api/config/print", method: "put", data: t });
}
function d() {
  return e({ url: "/api/config/car/model", method: "get" });
}
function p(t) {
  return e({ url: "/api/config/car/model", method: "put", data: t });
}
function m() {
  return e({ url: "/api/config/flanging_piece_price", method: "get" });
}
function h(t) {
  return e({ url: "/api/config/flanging_piece_price", method: "put", data: t });
}
function C() {
  return e({ module: "config", url: "getTechnicalType", method: "get" });
}
function M(t) {
  return e({ module: "config", url: "setTechnicalType", method: "put", data: t });
}
function P() {
  return e({ module: "config", url: "getSteelPlate", method: "get" });
}
function S(t) {
  return e({ module: "config", url: "setSteelPlate", method: "put", data: t });
}
function w() {
  return e({ module: "config", url: "getWeight", method: "get" });
}
function T(t) {
  return e({ module: "config", url: "setWeight", method: "put", data: t });
}
function y() {
  return e({ module: "config", url: "show/need", method: "get" });
}
function v({ type: t }) {
  return e({ module: "config", url: `show/need/${t}`, method: "put" });
}
function W() {
  return e({ module: "config", url: "getFeatureDefinitionConfig", method: "get" });
}
function R(t) {
  return e({ module: "config", url: "setFeatureDefinitionConfig", method: "put", data: t });
}
function b() {
  return e({ module: "config", url: "getPriceEditMode", method: "get" });
}
function D(t) {
  return e({ module: "config", url: "editPriceEditMode", method: "post", data: t });
}
function F() {
  return e({ module: "config", url: "getPriceEditMode/public", method: "get" });
}
function k() {
  return e({ url: "/api/mes/building/print/config/app/getConfig", method: "get" });
}
function E(t) {
  return e({ url: "/api/mes/building/print/config/app/updateConfig", method: "post", data: t });
}
function A(t) {
  return e({ url: "/api/user/deepen", method: "put", data: t });
}
function I() {
  return e({ url: "/api/config/getCoatingConfigMeasurementManner/public", method: "get" });
}
function L(t) {
  return e({ url: "/api/config/setCoatingConfigMeasurementManner", method: "put", params: t });
}
function O() {
  return e({ url: "/api/config/inventoryConfiguration", method: "get" });
}
function _(t) {
  return e({ url: "/api/config/inventoryConfiguration", method: "put", data: t });
}
function N() {
  return e({ url: "/api/config/wage-config/get", method: "get" });
}
function x(t) {
  return e({ url: "/api/config/wage-config/edit", method: "POST", data: t });
}
function j() {
  return e({ url: "/api/config/material/loss", method: "get" });
}
function q(t) {
  return e({ url: "/api/config/material/loss", method: "put", params: t });
}
function z() {
  return e({ url: "api/config/cappWeldingCraft/get", method: "get" });
}
function B(t) {
  return e({ url: "api/config/cappWeldingCraft/update", method: "put", data: t });
}
function G() {
  return e({ url: "/api/config/getMesWarehouseConfig", method: "get" });
}
function H(t) {
  return e({ url: "/api/config/setMesWarehouseConfig", method: "post", data: t });
}
function J() {
  return e({ url: "/api/config/nesting-task-setting/get", method: "get" });
}
function K(t) {
  return e({ url: "/api/config/nesting-task-setting/edit", method: "post", params: t });
}
function Q() {
  return e({ url: "/api/config/print/config", method: "get" });
}
function $(t) {
  return e({ url: "/api/config/print/config", method: "put", data: t });
}
export {
  K as A,
  i as B,
  o as C,
  b as D,
  D as E,
  Q as F,
  $ as G,
  j as H,
  q as I,
  r as J,
  u as K,
  P as L,
  S as M,
  W as N,
  R as O,
  N as P,
  x as Q,
  z as R,
  B as S,
  F as T,
  C as a,
  I as b,
  c,
  l as d,
  k as e,
  E as f,
  d as g,
  w as h,
  T as i,
  p as j,
  A as k,
  f as l,
  s as m,
  g as n,
  a as o,
  m as p,
  h as q,
  O as r,
  M as s,
  _ as t,
  y as u,
  v,
  L as w,
  G as x,
  H as y,
  J as z
};
