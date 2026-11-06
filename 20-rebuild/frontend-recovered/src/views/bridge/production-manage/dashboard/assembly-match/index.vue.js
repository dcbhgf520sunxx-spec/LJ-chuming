import { ref as n } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as U } from "vue";
import { normalizeStyle as v } from "vue";
import { Fragment as W } from "vue";
import { renderList as F } from "vue";
import { createBlock as O } from "vue";
import { withCtx as N } from "vue";
import { toDisplayString as x } from "vue";
import { withModifiers as Q } from "vue";
import { createCommentVNode as y } from "vue";
import { ElMessage as z } from "element-plus";
import { ElCheckbox as G } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { Loading as K } from "@element-plus/icons-vue";
import { ElIcon as j } from "element-plus";
import { ElInfiniteScroll as J } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { c as X } from "../../../../../modules/assembly-match-ac180441.js";
import { _ as Y, x as Z, o as ee, D as w } from "../../../../../shared/runtime.js";
import { v as te } from "../../../../../modules/bridge-86f96a4f.js";
import { u as ae } from "../../../../../modules/use-dashboard-index-0e26908e.js";
import se from "./module/header.vue.js";
import oe from "./module/part-production-status.vue.js";
import ne from "./module/part-production-list.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-f1034215.js";
import "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
const le = { class: "app-container" }, ie = { style: { display: "flex" } }, re = { style: { width: "70%" } }, ce = ["infinite-scroll-disabled"], de = ["onClick"], ue = { class: "ellipsis-text" }, pe = { class: "ellipsis-text" }, _e = { class: "ellipsis-text" }, fe = { key: 0, class: "red-tip" }, he = { style: { flex: "1" } }, me = { __name: "index", setup(ge) {
  const B = { add: false, edit: false, del: false, download: false }, b = n(), k = n(), D = n(), { crud: i, CRUD: S } = Z({ title: "项目齐套", permission: { ...te }, crudApi: { ...X }, optShow: { ...B }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, D), { maxHeight: E } = ee({ paginate: false }), { boxStyle: C, load: $, boardList: p } = ae({ headRef: k, scrollBoxRef: b, crud: i, CRUD: S, pageSize: 20, intervalTime: 1e3 }), I = n(false), h = n([]), m = n(), o = n([]);
  function T() {
    o.value = [];
  }
  function M(a, s) {
    const d = o.value.findIndex((g) => g.id === s.id);
    a ? d === -1 && o.value.push(s) : d > -1 && o.value.splice(d, 1);
  }
  function V(a) {
    I.value = a, p.value.forEach((s) => {
      s.checked = a, M(a, s);
    });
  }
  const _ = n(false);
  function L(a) {
    h.value = [a.id], m.value = [{ name: a.serialNumber, tagType: a.tagType }], _.value = true;
  }
  function R() {
    if (o.value.length <= 0) {
      z.warning("至少选择一个分段进行匹配查询");
      return;
    }
    h.value = o.value.map((a) => a.id), m.value = o.value.map((a) => ({ name: a.serialNumber, tagType: a.tagType })), _.value = true;
  }
  return (a, s) => {
    const d = G, g = H, q = K, A = j, P = J;
    return r(), u("div", le, [l("div", ie, [l("div", re, [c(t(se), { ref_key: "headRef", ref: k, onLoad: t($), isIndeterminate: o.value.length > 0 && o.value.length !== t(p) && !I.value, onCheckedAll: V, onBatchMatch: R, onClear: T }, null, 8, ["onLoad", "isIndeterminate"]), t(i).firstLoaded ? U((r(), u("div", { key: 0, ref_key: "scrollBoxRef", ref: b, class: "board-container", "infinite-scroll-disabled": t(i).loading || !t(i).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: v({ "max-height": `${t(E)}px` }) }, [(r(true), u(W, null, F(t(p), (e) => (r(), O(g, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          规格：${e.specification}

          长度：${e.length} mm

          材质：${e.material}

          单净重：${e.netWeight.toFixed(t(w).COM_WT__KG)} kg

          单毛重：${e.grossWeight.toFixed(t(w).COM_WT__KG)} kg

          所需数量：${e.needQuantity}

          `, placement: "left-start" }, { default: N(() => [l("div", { class: "board-box", style: v([{ position: "relative", cursor: "pointer" }, { "background-color": `${e.boxColor}`, ...t(C) }]), onClick: (f) => L(e) }, [l("span", ue, x(e.name), 1), l("span", pe, x(e.serialNumber), 1), l("span", _e, x(e.needQuantity), 1), c(d, { style: { position: "absolute", right: "10px", bottom: "0px" }, modelValue: e.checked, "onUpdate:modelValue": (f) => e.checked = f, onClick: s[0] || (s[0] = Q(() => {
    }, ["stop"])), onChange: (f) => M(f, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])], 12, de)]), _: 2 }, 1032, ["content"]))), 128)), !t(p).length && !t(i).loading ? (r(), u("span", fe, "* 暂无数据")) : y("", true), t(i).loading ? (r(), u("div", { key: 1, class: "loading-box", style: v(t(C)) }, [s[2] || (s[2] = l("span", null, "加载中", -1)), c(A, null, { default: N(() => [c(q)]), _: 1 })], 4)) : y("", true)], 12, ce)), [[P, t($)]]) : y("", true)]), l("div", he, [c(ne, { query: t(i).query }, null, 8, ["query"])])]), c(oe, { visible: _.value, "onUpdate:visible": s[1] || (s[1] = (e) => _.value = e), ids: h.value, names: m.value }, null, 8, ["visible", "ids", "names"])]);
  };
} }, Le = Y(me, [["__scopeId", "data-v-11c83e9c"]]);
export {
  Le as default
};
