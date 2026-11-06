import { ref as b } from "vue";
import { watch as K } from "vue";
import { computed as v } from "vue";
import { provide as J } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as t } from "vue";
import { createBlock as a } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as s } from "vue";
import { unref as n } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as Z } from "vue";
import { toDisplayString as I } from "vue";
import { isRef as $ } from "vue";
import { ElBadge as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { _ as ae, u as le, o as re, x as ne, kG as h, kC as L, P as ie } from "../../../../../shared/runtime.js";
import { c as se, s as ue } from "./module/summary-list.vue.js";
import ce from "./module/header.vue.js";
import "../../../../../modules/manuf-warehouse-select-bae65ecc.js";
import "../../../../../modules/enclosure-6f8adfb8.js";
import "../../../../../modules/project-select-94bb5bbd.js";
const pe = { class: "head-container head-flex" }, de = { class: "buttom-list" }, me = { key: 0 }, ye = { key: 1 }, ve = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "success"], setup(U, { emit: V }) {
  const A = V, E = U, { visible: _, handleClose: N } = le({ emit: A, props: E, field: "visible", showHook: O, closeHook: X }), { maxHeight: T } = re({ paginate: true, extraBox: [".el-drawer__header", ".head-flex"], wrapperBox: [".el-drawer__body"], extraHeight: 100 }), w = b(), g = b(), k = b(false), i = b([]), { crud: e, CRUD: D } = ne({ title: "制成品退货-创建", sort: [], crudApi: { ...se }, requiredQuery: ["projectId"], hasPagination: true, queryOnPresenterCreated: false }, w);
  K([() => e.query.projectId, () => e.query.type, () => e.query.status], () => {
    i.value = [];
  });
  const m = v(() => e.query.type === h.AUXILIARY_MATERIAL.V), u = v(() => e.query.type === h.ENCLOSURE.V), d = v(() => e.query.type === h.STRUCTURE.V), q = v(() => e.query.type === h.AUXILIARY_MATERIAL.V && e.query.relationType === L.STRUCTURE.V), B = v(() => e.query.type === h.AUXILIARY_MATERIAL.V && e.query.relationType === L.ENCLOSURE.V);
  function H(y) {
    return i.value.findIndex((r) => r.id === y.id) === -1;
  }
  function j() {
    i.value = i.value.concat(e.selections), w.value.clearSelection();
  }
  function P() {
    k.value = true;
  }
  function M(y) {
    i.value.splice(y, 1);
  }
  function O() {
    e.query.projectId && e.toQuery();
  }
  function Q() {
    i.value = [], e.toQuery();
  }
  function X() {
    e.resetQuery(), g.value.resetForm(), A("success"), i.value = [];
  }
  return D.HOOK.handleRefresh = async (y, { data: r }) => {
    g.value.resetForm(), w.value.clearSelection();
  }, J("query", e.query), (y, r) => {
    const R = x("common-button"), Y = ee, o = te, F = x("common-table"), W = ie, z = x("common-drawer"), G = oe;
    return t(), a(z, { "append-to-body": "", ref: "drawerRef", title: "制成品退货创建", modelValue: n(_), "onUpdate:modelValue": r[1] || (r[1] = (c) => $(_) ? _.value = c : null), direction: "rtl", "before-close": n(N), size: "100%" }, { content: p(() => [f("div", pe, [s(n(ce)), f("div", de, [n(e).query.projectId ? (t(), a(R, { key: 0, class: "add-btn", type: "success", onClick: j, disabled: !n(e).data.length }, { default: p(() => r[2] || (r[2] = [S(" 添加 ")])), _: 1, __: [2] }, 8, ["disabled"])) : l("", true), n(e).query.projectId ? (t(), a(Y, { key: 1, value: i.value.length, max: 99, hidden: i.value.length < 1 }, { default: p(() => [s(R, { type: "warning", onClick: P, disabled: !i.value.length }, { default: p(() => r[3] || (r[3] = [S("批量处理")])), _: 1, __: [3] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])) : l("", true)])]), n(e).query.projectId ? (t(), C("div", ye, [Z((t(), a(F, { ref_key: "tableRef", ref: w, data: n(e).data, "empty-text": n(e).emptyText, "max-height": n(T), style: { width: "100%" }, onSelectionChange: n(e).selectionChangeHandler }, { default: p(() => [s(o, { key: "selection", type: "selection", width: "55", align: "center", selectable: H }), s(o, { label: "序号", type: "index", align: "center", width: "60" }), d.value || q.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "monomerName", key: "monomerName", label: "单体", align: "center" })) : l("", true), d.value || q.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "areaName", key: "areaName", label: "区域", align: "center" })) : l("", true), u.value || B.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "planName", key: "planName", label: "计划", align: "center" })) : l("", true), s(o, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), m.value ? l("", true) : (t(), a(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" })), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" })) : l("", true), s(o, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }), d.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : l("", true), m.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : l("", true), m.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : l("", true), d.value || m.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" })) : l("", true), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量（张）", align: "center" })) : l("", true), m.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : l("", true), d.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center" })) : l("", true), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长度（m）", align: "center" })) : l("", true), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center" }, { default: p((c) => [f("span", null, I(c.row.surfaceArea || "-"), 1)]), _: 1 })) : l("", true), d.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : l("", true), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "totalLength", key: "totalLength", label: "总长度（m）", align: "center" })) : l("", true), u.value ? (t(), a(o, { "show-overflow-tooltip": "", prop: "totalArea", key: "totalArea", label: "总面积（㎡）", align: "center" }, { default: p((c) => [f("span", null, I(c.row.totalArea || "-"), 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[G, n(e).loading]]), s(W)])) : (t(), C("div", me, r[4] || (r[4] = [f("span", { style: { color: "red" } }, "* 请先选择项目", -1)]))), s(n(ue), { ref_key: "sunmmaryListRef", ref: g, visible: k.value, "onUpdate:visible": r[0] || (r[0] = (c) => k.value = c), auditDataList: i.value, onDelete: M, onSuccess: Q }, null, 8, ["visible", "auditDataList"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, qe = ae(ve, [["__scopeId", "data-v-83fb28b3"]]);
export {
  qe as default
};
