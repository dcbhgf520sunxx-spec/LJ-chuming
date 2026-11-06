import { ref as r } from "vue";
import Q from "moment";
import { resolveComponent as v } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as x } from "vue";
import { withKeys as F } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as c } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as V } from "vue";
import { unref as o } from "vue";
import { toDisplayString as G } from "vue";
import { createCommentVNode as W } from "vue";
import { isRef as X } from "vue";
import { Fragment as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as oe } from "element-plus";
import { vLoading as ne } from "element-plus";
import { g as le, b as ie } from "../../../../modules/notification-announcement-a0e50fbd.js";
import { u as se, J as re, o as me, p as ue, L as ce } from "../../../../shared/runtime.js";
import de from "./detail-dialog.vue.js";
import "../../../../modules/home-page-66a3681d.js";
const pe = { class: "head-container" }, ye = { __name: "list-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(k, { emit: D }) {
  const z = r(), T = D, N = k, { visible: u, handleClose: B } = se({ emit: T, props: N, field: "visible", showHook: I, closeHook: P }), { handleSizeChange: L, handleCurrentChange: H, total: S, setTotalPage: U, queryPage: d } = re({ fetchHook: i }), { maxHeight: E } = me({ mainBox: ".notification-announcement-list-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => u.value), p = { informantDateTime: Q().valueOf() }, f = r(false), w = r([]), l = r({ ...p }), g = r(false), y = r({});
  function I() {
    i();
  }
  function P() {
    l.value = { ...p };
  }
  function Y() {
    l.value = { ...p }, i();
  }
  async function i() {
    try {
      f.value = true;
      const { content: s, totalElements: e } = await le({ ...d, ...l.value });
      w.value = s, U(e);
    } catch (s) {
      console.log("获取通知公告列表", s);
    } finally {
      f.value = false;
    }
  }
  function O(s) {
    g.value = true, y.value = s;
  }
  return (s, e) => {
    const R = ee, q = te, _ = v("common-button"), m = ae, M = v("common-table"), $ = oe, A = v("common-drawer"), K = ne;
    return h(), j(Z, null, [a(A, { ref_key: "drawerRef", ref: z, title: "通知公告", "custom-class": "notification-announcement-list-drawer", modelValue: o(u), "onUpdate:modelValue": e[2] || (e[2] = (t) => X(u) ? u.value = t : null), direction: "rtl", "before-close": o(B), size: "900px" }, { content: n(() => [x("div", pe, [a(R, { modelValue: l.value.informantDateTime, "onUpdate:modelValue": e[0] || (e[0] = (t) => l.value.informantDateTime = t), type: "year", format: "YYYY", class: "filter-item", "value-format": "x", placeholder: "请选择", style: { width: "150px" }, onChange: i }, null, 8, ["modelValue"]), a(q, { modelValue: l.value.createUserName, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.value.createUserName = t), placeholder: "输入创建人搜索", class: "filter-item", style: { width: "200px" }, size: "small", clearable: "", onKeyup: F(i, ["enter"]) }, null, 8, ["modelValue"]), a(_, { class: "filter-item", size: "mini", type: "success", icon: "el-icon-search", onClick: C(i, ["stop"]) }, { default: n(() => e[4] || (e[4] = [c("搜索")])), _: 1, __: [4] }), a(_, { class: "filter-item", size: "mini", type: "warning", icon: "el-icon-refresh-left", onClick: C(Y, ["stop"]) }, { default: n(() => e[5] || (e[5] = [c(" 重置 ")])), _: 1, __: [5] })]), J((h(), V(M, { data: w.value, "max-height": o(E), "row-key": "rowId", style: { width: "100%" } }, { default: n(() => [a(m, { label: "序号", type: "index", align: "center", width: "60" }), a(m, { align: "center", "show-overflow-tooltip": true, prop: "name", label: "日期", width: "140px" }, { default: n(({ row: t }) => [x("span", null, G(o(ue)(t.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), a(m, { align: "center", "show-overflow-tooltip": true, prop: "createUserName", label: "创建人", width: "120px" }), a(m, { align: "center", "show-overflow-tooltip": true, prop: "title", label: "标题" }), a(m, { align: "center", label: "操作", width: "170px" }, { default: n(({ row: t }) => {
      var b;
      return [a(_, { type: "primary", size: "mini", onClick: (fe) => O(t) }, { default: n(() => e[6] || (e[6] = [c("预览")])), _: 2, __: [6] }, 1032, ["onClick"]), (b = t.attachmentDTOList) != null && b.length ? (h(), V(ce, { key: 0, type: "success", fn: o(ie), params: { attachmentDTOList: t.attachmentDTOList } }, { default: n(() => e[7] || (e[7] = [c(" 下载 ")])), _: 2, __: [7] }, 1032, ["fn", "params"])) : W("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[K, f.value]]), a($, { total: o(S), "current-page": o(d).pageNumber, "page-size": o(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(L), onCurrentChange: o(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), a(de, { modelValue: g.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => g.value = t), detailId: y.value.id, onDelSuccess: i }, null, 8, ["modelValue", "detailId"])], 64);
  };
} };
export {
  ye as default
};
