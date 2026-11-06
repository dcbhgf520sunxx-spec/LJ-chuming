import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/mes/building/wage-manage/coating-process/list", method: "get", params: e });
}
function n(e) {
  return t({ url: `/api/mes/building/wage-manage/coating-process/${e}`, method: "delete" });
}
function s(e) {
  return t({ url: "/api/mes/building/wage-manage/coating-process", method: "put", data: e });
}
function o(e) {
  return t({ url: "/api/mes/building/wage-manage/coating-process/coating-process-artifact-list", method: "get", params: e });
}
function g(e) {
  return t({ url: "/api/mes/building/wage-manage/coating-process/edit-artifact-list", method: "put", data: e });
}
function c(e) {
  return t({ url: "/api/mes/building/wage-manage/coating-process/coating-process-artifact-detail-page", method: "get", params: e });
}
function u(e, a) {
  return t({ url: `/api/mes/building/wage-manage/coating-process/coating-process-artifact-detail-delete?coatingProcessId=${a}`, method: "delete", data: e });
}
const d = { get: i, edit: s, del: n };
export {
  c as a,
  i as b,
  d as c,
  u as d,
  g as e,
  o as g
};
