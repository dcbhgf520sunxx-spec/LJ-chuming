import { useStore as I } from "vuex";
import { ref as w } from "vue";
import { inject as P } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createBlock as a } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as H } from "vue";
import { unref as e } from "vue";
import { createTextVNode as K } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as M } from "vue";
import { normalizeStyle as j } from "vue";
import { ElMessageBox as z } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as $ } from "element-plus";
import { ElTooltip as q } from "element-plus";
import { ElSwitch as J } from "element-plus";
import { ElCard as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as X, e as Z } from "../../../../../modules/factory-7a1d88b2.js";
import { _ as ee, x as te, b7 as _, G as g, b8 as oe, aS as m, an as ae, P as ne } from "../../../../../shared/runtime.js";
import le from "./module/header.vue.js";
import ie from "./module/form.vue.js";
const re = { style: { "line-height": "1.7" } }, se = { class: "head-container" }, ce = { style: { display: "inline-block" } }, de = { __name: "index", emits: ["click-factory"], setup(me, { emit: C }) {
  const v = I(), k = C, S = { add: false, edit: false, del: false, download: false }, y = w(), { crud: s, columns: u, CRUD: f } = te({ title: "工厂", sort: [], permission: { ..._ }, optShow: { ...S }, crudApi: { ...X }, invisibleColumns: ["shortName", "remark"] }, y), T = w([["targetProduction", ["to-fixed", 2]]]), V = P("maxHeight");
  f.HOOK.handleRefresh = (i, { data: t }) => {
    t.content.forEach((h) => {
    });
  };
  async function N(i, t) {
    try {
      await z.confirm('此操作将 "' + m.VL[t] + '" ' + i.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Z({ id: i.id, boolEnabledEnum: t }), s.refresh(), s.notify(m.VL[t] + "成功", f.NOTIFICATION_TYPE.SUCCESS), b();
    } catch (h) {
      console.log("变更工厂状态", h), i.boolEnabledEnum = i.boolEnabledEnum === m.TRUE.V ? m.FALSE.V : m.TRUE.V;
    }
  }
  function O(i) {
    i && k("click-factory", i);
  }
  f.HOOK.afterSubmit = () => {
    b();
  }, f.HOOK.afterDelete = () => {
    b();
  };
  function b() {
    v.commit("config/SET_LOADED", { key: "factories", loaded: false });
  }
  return (i, t) => {
    const h = x("common-button"), r = G, F = Y, R = $, A = q, D = J, L = x("common-table"), U = Q, B = W;
    return o(), a(U, null, { header: n(() => [p("span", re, H(e(s).title) + "列表", 1), e(g)(e(_).add) ? (o(), a(h, { key: 0, class: "filter-item", style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(s).toAdd, disabled: e(s).data.length === 1 }, { default: n(() => t[0] || (t[0] = [K(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick", "disabled"])) : d("", true)]), default: n(() => [p("div", se, [l(e(le))]), M((o(), a(L, { ref_key: "tableRef", ref: y, data: e(s).data, "highlight-current-row": "", "data-format": T.value, "max-height": e(V), "empty-text": e(s).emptyText, style: { width: "100%" }, onCurrentChange: O }, { default: n(() => [l(r, { label: "序号", type: "index", align: "center", width: "60" }), e(u).visible("branchCompanyName") ? (o(), a(r, { key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "分支机构", "min-width": "100px" })) : d("", true), l(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工厂名称", "min-width": "140px" }), e(u).visible("shortName") ? (o(), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "工厂简称", "min-width": "140px" })) : d("", true), e(u).visible("tagColor") ? (o(), a(r, { key: "tagColor", prop: "tagColor", "show-overflow-tooltip": true, label: "标签颜色", align: "center", width: "100px" }, { default: n((c) => [p("span", { class: "color-card", style: j({ "background-color": c.row.tagColor || e(oe) }) }, null, 4)]), _: 1 })) : d("", true), e(u).visible("boolEnabledEnum") ? (o(), a(r, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center", width: "80px" }, { header: n(() => [l(A, { class: "item", effect: "light", content: "工厂被禁用后，该工厂无法再在其它页面中显示", placement: "top" }, { default: n(() => [p("div", ce, [t[1] || (t[1] = p("span", null, "状态", -1)), l(R, null, { default: n(() => [l(F)]), _: 1 })])]), _: 1 })]), default: n((c) => [l(D, { modelValue: c.row.boolEnabledEnum, "onUpdate:modelValue": (E) => c.row.boolEnabledEnum = E, disabled: !e(g)(e(_).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(m).TRUE.V, "inactive-value": e(m).FALSE.V, onChange: (E) => N(c.row, c.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : d("", true), e(u).visible("sort") ? (o(), a(r, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : d("", true), e(u).visible("remark") ? (o(), a(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : d("", true), e(g)([...e(_).del, ...e(_).edit]) ? (o(), a(r, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((c) => [l(e(ae), { data: c.row }, null, 8, ["data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "empty-text"])), [[B, e(s).loading]]), l(e(ne)), l(e(ie))]), _: 1 });
  };
} }, ge = ee(de, [["__scopeId", "data-v-1a112f44"]]);
export {
  ge as default
};
