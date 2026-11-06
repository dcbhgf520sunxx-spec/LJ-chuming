import { ref as u } from "vue";
import W from "moment";
import { resolveComponent as b } from "vue";
import { openBlock as c } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as a } from "vue";
import { withKeys as A } from "vue";
import { withModifiers as T } from "vue";
import { createTextVNode as p } from "vue";
import { withDirectives as G } from "vue";
import { unref as o } from "vue";
import { toDisplayString as z } from "vue";
import { createElementBlock as X } from "vue";
import { createCommentVNode as H } from "vue";
import { isRef as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { g as ne, d as se } from "../../../../modules/enterprise-cloud-disk-7c8bf938.js";
import { u as ie, J as re, o as ue, p as me, W as de, L as ce } from "../../../../shared/runtime.js";
import pe from "./detail-dialog.vue.js";
import "../../../../modules/home-page-66a3681d.js";
const fe = { class: "head-container" }, ge = { key: 0 }, xe = { __name: "list-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "del-success"], setup(L, { emit: E }) {
  const S = u(), C = E, B = L, { visible: d, handleClose: N } = ie({ emit: C, props: B, field: "visible", showHook: F, closeHook: R }), { handleSizeChange: U, handleCurrentChange: I, total: O, setTotalPage: P, queryPage: f } = re({ fetchHook: s }), { maxHeight: Y } = ue({ mainBox: ".enterprise-cloud-disk-list-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => d.value), g = { informantDateTime: W().valueOf() }, _ = u(false), k = u([]), n = u({ ...g }), h = u(false), y = u({});
  function F() {
    s();
  }
  function R() {
    n.value = { ...g };
  }
  function q() {
    n.value = { ...g }, s();
  }
  async function s() {
    try {
      _.value = true;
      const { content: i, totalElements: e } = await ne({ ...f, ...n.value });
      k.value = i.map((m) => (m.nameStrings = m.attachmentDTOList.map((v) => v.name).join("、"), m)), P(e);
    } catch (i) {
      console.log("获取企业网盘列表", i);
    } finally {
      _.value = false;
    }
  }
  function M(i) {
    h.value = true, y.value = i;
  }
  function $() {
    C("del-success"), s();
  }
  return (i, e) => {
    const m = ee, v = te, w = b("common-button"), r = ae, j = b("common-table"), K = oe, Q = b("common-drawer"), J = le;
    return c(), x(Q, { ref_key: "drawerRef", ref: S, "custom-class": "enterprise-cloud-disk-list-drawer", title: "企业网盘", modelValue: o(d), "onUpdate:modelValue": e[3] || (e[3] = (t) => Z(d) ? d.value = t : null), direction: "rtl", "before-close": o(N), size: "900px" }, { content: l(() => [D("div", fe, [a(m, { modelValue: n.value.informantDateTime, "onUpdate:modelValue": e[0] || (e[0] = (t) => n.value.informantDateTime = t), type: "year", format: "YYYY", class: "filter-item", "value-format": "x", placeholder: "请选择", style: { width: "150px" }, onChange: s }, null, 8, ["modelValue"]), a(v, { modelValue: n.value.createUserName, "onUpdate:modelValue": e[1] || (e[1] = (t) => n.value.createUserName = t), placeholder: "输入创建人搜索", class: "filter-item", style: { width: "200px" }, size: "small", clearable: "", onKeyup: A(s, ["enter"]) }, null, 8, ["modelValue"]), a(w, { class: "filter-item", size: "mini", type: "success", icon: "el-icon-search", onClick: T(s, ["stop"]) }, { default: l(() => e[4] || (e[4] = [p("搜索")])), _: 1, __: [4] }), a(w, { class: "filter-item", size: "mini", type: "warning", icon: "el-icon-refresh-left", onClick: T(q, ["stop"]) }, { default: l(() => e[5] || (e[5] = [p(" 重置 ")])), _: 1, __: [5] })]), G((c(), x(j, { data: k.value, "max-height": o(Y), "row-key": "rowId", style: { width: "100%" } }, { default: l(() => [a(r, { label: "序号", type: "index", align: "center", width: "60" }), a(r, { align: "center", "show-overflow-tooltip": true, prop: "name", label: "日期", width: "140px" }, { default: l(({ row: t }) => [D("span", null, z(o(me)(t.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), a(r, { align: "center", "show-overflow-tooltip": true, prop: "createUserName", label: "创建人", width: "120px" }), a(r, { align: "center", "show-overflow-tooltip": true, prop: "sysHomeFileType", label: "文件类型", width: "140px" }, { default: l(({ row: t }) => [t.sysHomeFileType ? (c(), X("span", ge, z(o(de).VL[t.sysHomeFileType]), 1)) : H("", true)]), _: 1 }), a(r, { align: "center", "show-overflow-tooltip": true, prop: "nameStrings", label: "标题" }), a(r, { align: "center", label: "操作", width: "170px" }, { default: l(({ row: t }) => {
      var V;
      return [a(w, { type: "primary", size: "mini", onClick: (_e) => M(t) }, { default: l(() => e[6] || (e[6] = [p("预览")])), _: 2, __: [6] }, 1032, ["onClick"]), (V = t.attachmentDTOList) != null && V.length ? (c(), x(ce, { key: 0, type: "success", fn: o(se), params: { attachmentDTOList: t.attachmentDTOList } }, { default: l(() => e[7] || (e[7] = [p(" 下载 ")])), _: 2, __: [7] }, 1032, ["fn", "params"])) : H("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, _.value]]), a(K, { total: o(O), "current-page": o(f).pageNumber, "page-size": o(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(U), onCurrentChange: o(I) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(pe, { modelValue: h.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => h.value = t), detailId: y.value.id, detail: y.value, onDelSuccess: $ }, null, 8, ["modelValue", "detailId", "detail"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  xe as default
};
