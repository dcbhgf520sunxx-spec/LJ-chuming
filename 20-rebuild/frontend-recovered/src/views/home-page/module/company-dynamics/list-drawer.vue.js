import { ref as r } from "vue";
import j from "moment";
import { resolveComponent as y } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as t } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as x } from "vue";
import { withKeys as J } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as c } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as V } from "vue";
import { unref as o } from "vue";
import { toDisplayString as G } from "vue";
import { createCommentVNode as W } from "vue";
import { isRef as X } from "vue";
import { Fragment as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElPagination as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { g as ne, b as ie } from "../../../../modules/company-dynamics-34941552.js";
import { u as se, J as re, o as me, p as ue, L as ce } from "../../../../shared/runtime.js";
import de from "./detail-dialog.vue.js";
import "../../../../modules/home-page-66a3681d.js";
const pe = { class: "head-container" }, we = { __name: "list-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(k, { emit: D }) {
  const z = r(), T = D, B = k, { visible: u, handleClose: L } = se({ emit: T, props: B, field: "visible", showHook: I, closeHook: P }), { handleSizeChange: N, handleCurrentChange: H, total: S, setTotalPage: U, queryPage: d } = re({ fetchHook: i }), { maxHeight: E } = me({ mainBox: ".company-dynamics-list-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => u.value), p = { informantDateTime: j().valueOf() }, f = r(false), h = r([]), n = r({ ...p }), g = r(false), w = r({});
  function I() {
    i();
  }
  function P() {
    n.value = { ...p };
  }
  function Y() {
    n.value = { ...p }, i();
  }
  async function i() {
    try {
      f.value = true;
      const { content: s, totalElements: e } = await ne({ ...d, ...n.value });
      h.value = s, U(e);
    } catch (s) {
      console.log("获取公司动态列表", s);
    } finally {
      f.value = false;
    }
  }
  function O(s) {
    g.value = true, w.value = s;
  }
  return (s, e) => {
    const R = ee, q = ae, _ = y("common-button"), m = te, M = y("common-table"), $ = oe, K = y("common-drawer"), Q = le;
    return v(), F(Z, null, [t(K, { ref_key: "drawerRef", ref: z, title: "公司动态", "custom-class": "company-dynamics-list-drawer", modelValue: o(u), "onUpdate:modelValue": e[2] || (e[2] = (a) => X(u) ? u.value = a : null), direction: "rtl", "before-close": o(L), size: "900px" }, { content: l(() => [x("div", pe, [t(R, { modelValue: n.value.informantDateTime, "onUpdate:modelValue": e[0] || (e[0] = (a) => n.value.informantDateTime = a), type: "year", format: "YYYY", class: "filter-item", "value-format": "x", placeholder: "请选择", style: { width: "150px" }, onChange: i }, null, 8, ["modelValue"]), t(q, { modelValue: n.value.createUserName, "onUpdate:modelValue": e[1] || (e[1] = (a) => n.value.createUserName = a), placeholder: "输入创建人搜索", class: "filter-item", style: { width: "200px" }, size: "small", clearable: "", onKeyup: J(i, ["enter"]) }, null, 8, ["modelValue"]), t(_, { class: "filter-item", size: "mini", type: "success", icon: "el-icon-search", onClick: C(i, ["stop"]) }, { default: l(() => e[4] || (e[4] = [c("搜索")])), _: 1, __: [4] }), t(_, { class: "filter-item", size: "mini", type: "warning", icon: "el-icon-refresh-left", onClick: C(Y, ["stop"]) }, { default: l(() => e[5] || (e[5] = [c(" 重置 ")])), _: 1, __: [5] })]), A((v(), V(M, { data: h.value, "max-height": o(E), "row-key": "rowId", style: { width: "100%" } }, { default: l(() => [t(m, { label: "序号", type: "index", align: "center", width: "60" }), t(m, { align: "center", "show-overflow-tooltip": true, prop: "name", label: "日期", width: "140px" }, { default: l(({ row: a }) => [x("span", null, G(o(ue)(a.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), t(m, { align: "center", "show-overflow-tooltip": true, prop: "createUserName", label: "创建人", width: "120px" }), t(m, { align: "center", "show-overflow-tooltip": true, prop: "title", label: "标题" }), t(m, { align: "center", label: "操作", width: "170px" }, { default: l(({ row: a }) => {
      var b;
      return [t(_, { type: "primary", size: "mini", onClick: (fe) => O(a) }, { default: l(() => e[6] || (e[6] = [c("预览")])), _: 2, __: [6] }, 1032, ["onClick"]), (b = a.attachmentDTOList) != null && b.length ? (v(), V(ce, { key: 0, type: "success", fn: o(ie), params: { attachmentDTOList: a.attachmentDTOList } }, { default: l(() => e[7] || (e[7] = [c(" 下载 ")])), _: 2, __: [7] }, 1032, ["fn", "params"])) : W("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[Q, f.value]]), t($, { total: o(S), "current-page": o(d).pageNumber, "page-size": o(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(N), onCurrentChange: o(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), t(de, { modelValue: g.value, "onUpdate:modelValue": e[3] || (e[3] = (a) => g.value = a), detailId: w.value.id, onDelSuccess: i }, null, 8, ["modelValue", "detailId"])], 64);
  };
} };
export {
  we as default
};
