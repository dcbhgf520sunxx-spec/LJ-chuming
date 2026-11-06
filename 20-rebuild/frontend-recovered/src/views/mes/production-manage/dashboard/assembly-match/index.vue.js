import { ref as l } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as d } from "vue";
import { unref as s } from "vue";
import { withDirectives as P } from "vue";
import { normalizeStyle as b } from "vue";
import { Fragment as q } from "vue";
import { renderList as O } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as w } from "vue";
import { toDisplayString as x } from "vue";
import { withModifiers as z } from "vue";
import { createCommentVNode as y } from "vue";
import { ElMessage as G } from "element-plus";
import { ElCheckbox as K } from "element-plus";
import { ElTooltip as j } from "element-plus";
import { Loading as J } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElInfiniteScroll as Y } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { c as Z } from "../../../../../modules/assembly-match-4f9c2c34.js";
import { _ as ee, x as ae, pw as se, o as oe, D as B } from "../../../../../shared/runtime.js";
import { u as te } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import le from "./module/header.vue.js";
import ne from "./module/part-production-status.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "./module/not-complete-list.vue.js";
const ie = { class: "app-container" }, ce = ["infinite-scroll-disabled"], re = ["onClick"], de = { class: "ellipsis-text" }, ue = { class: "ellipsis-text" }, pe = { class: "ellipsis-text" }, _e = { key: 0, class: "red-tip" }, fe = { __name: "index", setup(he) {
  const D = { add: false, edit: false, del: false, download: false }, u = l(false), C = l(), I = l(), S = l(), { crud: h, CRUD: E } = ae({ title: "齐套看板", permission: { ...se }, crudApi: { ...Z }, optShow: { ...D }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, S), { maxHeight: V } = oe({ paginate: false }), { isLoading: m, boxStyle: T, load: $, boardList: p } = te({ headRef: I, scrollBoxRef: C, crud: h, CRUD: E, pageSize: 20, intervalTime: 1e3 }), M = l(false), v = l([]), g = l(), t = l([]);
  function H() {
    t.value = [], u.value = false;
  }
  function N(a, o) {
    const c = t.value.findIndex((k) => k.id === o.id);
    a ? c === -1 && t.value.push(o) : c > -1 && t.value.splice(c, 1);
  }
  function L(a) {
    M.value = a, p.value.forEach((o) => {
      o.checked = a, N(a, o);
    });
  }
  const _ = l(false);
  function R(a) {
    v.value = [a.id], g.value = [{ name: a.serialNumber, tagType: a.tagType }], u.value = a.boolHaveTask, _.value = true;
  }
  function A() {
    if (t.value.length <= 0) {
      G.warning("至少选择一个构件进行匹配查询");
      return;
    }
    v.value = t.value.map((a) => a.id), g.value = t.value.map((a) => ({ name: a.serialNumber, tagType: a.tagType })), u.value = t.value.some((a) => a.boolHaveTask), _.value = true;
  }
  return (a, o) => {
    const c = K, k = j, U = J, W = X, F = Y;
    return i(), r("div", ie, [n("div", null, [n("div", null, [d(s(le), { ref_key: "headRef", ref: I, onLoad: s($), isIndeterminate: t.value.length > 0 && t.value.length !== s(p) && !M.value, onCheckedAll: L, onBatchMatch: A, onClear: H }, null, 8, ["onLoad", "isIndeterminate"]), s(h).firstLoaded ? P((i(), r("div", { key: 0, ref_key: "scrollBoxRef", ref: C, class: "board-container", "infinite-scroll-disabled": s(m) || !s(h).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: b({ "max-height": `${s(V)}px` }) }, [(i(true), r(q, null, O(s(p), (e) => (i(), Q(k, { key: e.id, "open-delay": 1e3, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          规格：${e.specification}

          长度：${e.length} mm

          材质：${e.material}

          单净重：${e.netWeight.toFixed(s(B).COM_WT__KG)} kg

          单毛重：${e.grossWeight.toFixed(s(B).COM_WT__KG)} kg

          所需数量：${e.needQuantity}

          `, placement: "left-start" }, { default: w(() => [n("div", { class: "board-box", style: b([{ position: "relative", cursor: "pointer" }, { "background-color": `${e.boxColor}`, ...s(T) }]), onClick: (f) => R(e) }, [n("span", de, x(e.name), 1), n("span", ue, x(e.serialNumber), 1), n("span", pe, x(e.needQuantity), 1), d(c, { style: { position: "absolute", right: "10px", bottom: "0px" }, modelValue: e.checked, "onUpdate:modelValue": (f) => e.checked = f, onClick: o[0] || (o[0] = z(() => {
    }, ["stop"])), onChange: (f) => N(f, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])], 12, re)]), _: 2 }, 1032, ["content"]))), 128)), !s(p).length && !s(m) ? (i(), r("span", _e, "* 暂无数据")) : y("", true), s(m) ? (i(), r("div", { key: 1, class: "loading-box", style: b(s(T)) }, [o[2] || (o[2] = n("span", null, "加载中", -1)), d(W, null, { default: w(() => [d(U)]), _: 1 })], 4)) : y("", true)], 12, ce)), [[F, s($)]]) : y("", true)])]), d(ne, { visible: _.value, "onUpdate:visible": o[1] || (o[1] = (e) => _.value = e), ids: v.value, names: g.value, isIncludeboolHaveTask: u.value }, null, 8, ["visible", "ids", "names", "isIncludeboolHaveTask"])]);
  };
} }, De = ee(fe, [["__scopeId", "data-v-ac22ee68"]]);
export {
  De as default
};
