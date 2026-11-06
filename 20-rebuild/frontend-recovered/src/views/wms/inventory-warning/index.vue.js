import { ElMessage as C } from "element-plus";
import { ref as U } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as o } from "vue";
import { withCtx as y } from "vue";
import { createCommentVNode as r } from "vue";
import { createElementVNode as O } from "vue";
import { toDisplayString as b } from "vue";
import { createTextVNode as N } from "vue";
import { Fragment as z } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as W } from "element-plus";
import { ElSwitch as j } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as K, e as q, a as Y } from "./module/notify-others.vue.js";
import { _ as Z, uv as J, x as Q, xZ as T, o as X, cO as ee, jl as te, cS as v, xP as ne, G as F, aS as ie, an as ae, P as oe, x_ as le } from "../../../shared/runtime.js";
import { u as se } from "../../../modules/use-crud-enabled-change-d83074a3.js";
import ce from "./module/header.vue.js";
import de from "./module/batch-form.vue.js";
import "../../../modules/dept-cascader-6af417b9.js";
import "../../../modules/use-dept-b8e95315.js";
const re = "source_";
function ue(I, g = [], k) {
  const p = /* @__PURE__ */ new Map(), E = Array.isArray(g) ? g : [g];
  E.forEach((n) => {
    p.set(n, `${re}${n}`);
  });
  const x = (n) => {
    n.forEach((l) => {
      l.editMode = false, l.editLoading = false, p.forEach((s, c) => {
        l[s] = l[c];
      });
    });
  }, h = (n) => {
    p.forEach((l, s) => {
      n[s] = n[l];
    }), n.editMode = false, C({ message: "已退出修改", type: "warning" });
  }, d = async (n) => {
    if (!w(n)) {
      n.editMode = false, C({ message: "未发生修改", type: "info" });
      return;
    }
    n.editLoading = true;
    let s = { id: n.id };
    E.forEach((c) => {
      s[c] = n[c];
    }), typeof k == "function" && (s = await k(n, s));
    try {
      await I(s), n.editMode = false, p.forEach((c, M) => {
        n[c] = n[M];
      }), C({ message: "修改成功", type: "success" });
    } catch (c) {
      console.log("修改最低库存", c), C({ message: "保存失败", type: "error" });
    } finally {
      n.editLoading = false;
    }
  }, w = (n) => {
    let l = false;
    for (const [s, c] of p) if (n[s] !== n[c]) {
      l = true;
      break;
    }
    return l;
  };
  return { rowInit: x, cancelRowEdit: h, confirmRowEdit: d };
}
const me = { class: "app-container" }, pe = { key: 0, class: "edit-item" }, fe = { key: 1 }, _e = { __name: "index", setup(I) {
  const g = { batchAdd: true, add: false, edit: false, del: true, download: false }, k = ["minimumInventory"], p = U(), E = U([...J]), { CRUD: x, crud: h, columns: d } = Q({ title: "库存预警", sort: ["id.desc"], formStore: true, formStoreKey: "WMS_INVENTORY_WARNING", permission: { ...T }, optShow: { ...g }, crudApi: { ...K } }, p), { maxHeight: w } = X({ paginate: true }), { handleEnabledChange: n } = se({ CRUD: x, crud: h, editEnabled: q }), { rowInit: l, cancelRowEdit: s, confirmRowEdit: c } = ue(Y, k, M);
  x.HOOK.handleRefresh = async (f, { data: u }) => {
    await ee(u.content), u.content = await te(u.content, { toSmallest: false, toNum: true }), u.content.forEach((a) => {
      a.unit = a.unitType === v.MEASURE.V ? a.measureUnit : a.accountingUnit;
    }), l(u.content);
  };
  async function M(f, u) {
    return await le(u, { unit: f.unitType === v.MEASURE.V ? f.measureUnit : f.accountingUnit, precision: f.unitType === v.MEASURE.V ? f.measurePrecision : f.accountingPrecision, fields: ["minimumInventory"], toSmallest: true, toNum: true }), u;
  }
  return (f, u) => {
    const a = H, A = W, L = V("common-input-number"), S = V("common-button"), B = j, $ = V("common-table"), D = G;
    return i(), R("div", me, [m(t(ce)), P((i(), o($, { ref_key: "tableRef", ref: p, data: t(h).data, "data-format": E.value, "max-height": t(w), style: { width: "100%" }, onSelectionChange: t(h).selectionChangeHandler, "row-key": "id" }, { default: y(() => [m(a, { type: "selection", align: "center", width: "55" }), m(a, { label: "序号", type: "index", align: "center", width: "60" }), t(d).visible("serialNumber") ? (i(), o(a, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "编码", align: "left", width: "150" }, { default: y(({ row: e }) => [e.workshop ? (i(), o(ne, { key: 0, id: e.workshop.id }, null, 8, ["id"])) : r("", true), O("span", null, b(e.serialNumber), 1)]), _: 1 })) : r("", true), t(d).visible("classifyFullName") ? (i(), o(a, { key: "classifyFullName", "show-overflow-tooltip": true, prop: "classifyFullName", label: "科目", align: "left", "min-width": "180" })) : r("", true), t(d).visible("specification") ? (i(), o(a, { key: "specification", "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "left", "min-width": "150" })) : r("", true), t(d).visible("unit") ? (i(), o(a, { key: 3, "show-overflow-tooltip": true, prop: "unit", label: "单位", align: "left", width: "120" }, { default: y(({ row: { sourceRow: e } }) => [m(A, { type: e.unitType === t(v).MEASURE.V ? "" : "warning", style: { "margin-right": "8px" }, effect: "plain" }, { default: y(() => [N(b(t(v).VL[e.unitType]), 1)]), _: 2 }, 1032, ["type"]), N(" " + b(e.unit), 1)]), _: 1 })) : r("", true), t(d).visible("minimumInventory") ? (i(), o(a, { key: "minimumInventory", prop: "minimumInventory", label: "预警数量", align: "center", "min-width": "180" }, { default: y(({ row: { sourceRow: e } }) => [e.editMode ? (i(), R("div", pe, [m(L, { modelValue: e.minimumInventory, "onUpdate:modelValue": (_) => e.minimumInventory = _, disabled: e.editLoading, max: 999999, min: 0, precision: 0, "controls-position": "right", label: "描述文字", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"]), m(S, { class: "icon-button", size: "default", icon: "el-icon-circle-close", type: "warning", onClick: (_) => t(s)(e) }, null, 8, ["onClick"])])) : (i(), R("span", fe, b(e.minimumInventory), 1))]), _: 1 })) : r("", true), t(d).visible("enabled") ? (i(), o(a, { key: 5, "show-overflow-tooltip": true, prop: "enabled", label: "启用状态", align: "center", width: "100" }, { default: y(({ row: { sourceRow: e } }) => [t(F)(t(T).edit) ? (i(), o(B, { key: 0, disabled: e.enabledLoading, modelValue: e.enabled, "onUpdate:modelValue": (_) => e.enabled = _, class: "drawer-switch", onChange: (_) => t(n)(e, ["classifyFullName", "specification"]) }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])) : (i(), R(z, { key: 1 }, [N(b(t(ie).VL[e.enabled]), 1)], 64))]), _: 1 })) : r("", true), t(d).visible("updateTime") ? (i(), o(a, { key: "updateTime", prop: "updateTime", label: "编辑日期", width: "140px" })) : r("", true), t(d).visible("createTime") ? (i(), o(a, { key: "createTime", prop: "createTime", label: "创建日期", width: "140px" })) : r("", true), t(F)(t(T).edit) ? (i(), o(a, { key: 8, label: "操作", width: "130px", align: "center" }, { default: y(({ row: { sourceRow: e } }) => [e.editMode ? (i(), o(S, { key: 0, loading: e.editLoading, type: "success", size: "default", icon: "el-icon-check", onClick: (_) => t(c)(e) }, null, 8, ["loading", "onClick"])) : (i(), o(S, { key: 1, type: "primary", size: "default", icon: "el-icon-edit", onClick: (_) => e.editMode = !e.editMode }, null, 8, ["onClick"])), m(t(ae), { "show-edit": false, data: e }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[D, t(h).loading]]), m(t(oe)), m(t(de))]);
  };
} }, Ce = Z(_e, [["__scopeId", "data-v-38d30f21"]]);
export {
  Ce as default
};
