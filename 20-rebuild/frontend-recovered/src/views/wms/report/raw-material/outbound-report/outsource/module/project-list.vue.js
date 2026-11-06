import { ref as n } from "vue";
import { computed as O } from "vue";
import { resolveComponent as w } from "vue";
import { withDirectives as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as m } from "vue";
import { withCtx as P } from "vue";
import { createTextVNode as k } from "vue";
import { withModifiers as V } from "vue";
import { Fragment as Y } from "vue";
import { renderList as b } from "vue";
import { normalizeClass as L } from "vue";
import { toDisplayString as z } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElInput as E } from "element-plus";
import { vLoading as S } from "element-plus";
import { l as B, _ as I } from "../../../../../../../shared/runtime.js";
function q(p) {
  return B({ url: "/api/v2/wms/outbound/application/getOutsourcingProject", method: "get", params: p });
}
const F = { class: "project-container" }, M = { style: { margin: "10px 0" } }, T = { style: { "margin-bottom": "20px" } }, U = ["onClick"], $ = { __name: "project-list", emits: ["projectChange"], setup(p, { emit: f }) {
  const v = f, a = n({}), i = n(false), _ = n([]), c = n(), y = O(() => {
    let t = _.value;
    return a.value.year && (t = t.filter((e) => e.year.toString() === a.value.year.toString())), a.value.noOrProjectName && (t = t.filter((e) => {
      var r, l;
      return e.name.indexOf(a.value.noOrProjectName) > -1 || ((r = e.serialNumber) == null ? void 0 : r.indexOf(a.value.noOrProjectName)) > -1 || ((l = e.shortName) == null ? void 0 : l.indexOf(a.value.noOrProjectName)) > -1;
    })), t;
  });
  g();
  async function g() {
    let t = [];
    try {
      i.value = true, t = await q(), t.forEach((e) => {
        e.year = new Date(e.createTime).getFullYear();
      });
    } catch (e) {
      console.log("获取外协原料出库过的项目数据", e);
    } finally {
      _.value = t, i.value = false;
    }
  }
  function j() {
    a.value = {};
  }
  function h(t) {
    c.value = c.value === t.id ? void 0 : t.id, v("projectChange", t.id);
  }
  return (t, e) => {
    const r = D, l = E, x = w("common-button"), N = S;
    return C((u(), d("div", F, [e[3] || (e[3] = s("div", { style: { color: "#333" } }, "项目列表", -1)), s("div", M, [m(r, { modelValue: a.value.year, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.year = o), type: "year", size: "default", class: "date-item filter-item", style: { width: "100%" }, placeholder: "项目立项年份筛选", format: "YYYY", "value-format": "YYYY" }, null, 8, ["modelValue"])]), s("div", T, [m(l, { modelValue: a.value.noOrProjectName, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.noOrProjectName = o), modelModifiers: { trim: true }, size: "default", placeholder: "项目编号名称或简称", style: { width: "200px", "margin-right": "5px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), m(x, { class: "filter-item", size: "default", type: "warning", onClick: V(j, ["stop"]) }, { default: P(() => e[2] || (e[2] = [k(" 重置 ")])), _: 1, __: [2] })]), s("div", null, [(u(true), d(Y, null, b(y.value, (o) => (u(), d("div", { key: o.id, class: L(`project-item ${c.value === o.id ? "item-chose" : ""}`), onClick: (Q) => h(o) }, z(o.serialNumber + " " + o.name), 11, U))), 128))])])), [[N, i.value]]);
  };
} }, H = I($, [["__scopeId", "data-v-6447d0d1"]]);
export {
  H as default
};
