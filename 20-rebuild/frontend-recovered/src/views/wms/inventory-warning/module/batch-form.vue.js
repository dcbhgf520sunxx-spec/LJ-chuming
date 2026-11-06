import { reactive as L } from "vue";
import { ref as h } from "vue";
import { computed as G } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as $ } from "vue";
import { createBlock as j } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as d } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as q } from "vue";
import { ElTag as W } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElForm as Q } from "element-plus";
import { _ as X, a_ as Y, o as Z, cS as m, xG as ee, b4 as te, v6 as ne, r8 as I, aw as ie, aI as oe, b as S, i as T } from "../../../../shared/runtime.js";
const le = { class: "flex-rss" }, ae = { style: { width: "100%" } }, se = { class: "setting-container" }, ce = { class: "setting-item" }, ue = { class: "setting-item" }, de = { __name: "batch-form", setup(me) {
  const C = {}, x = { list: [] }, r = L({ minimumInventory: void 0, workshopId: void 0 }), w = h(), g = h(), p = h(), { CRUD: _, crud: a, form: f } = Y(x, g), v = G(() => a.bStatus.cu > _.STATUS.NORMAL), { tableValidate: B, cleanUpData: R, wrongCellMask: E } = ie({ rules: C }), { maxHeight: k } = Z({ mainBox: ".inventory-warning-batch-add", extraBox: [".el-dialog__header", ".setting-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, v);
  _.HOOK.beforeValidateBCU = () => {
    const { validResult: i, dealList: e } = B(f.list);
    if (i) f.list = e;
    else return i;
  }, _.HOOK.beforeToBCU = () => F(), a.submitBatchFormFormat = async (i) => {
    R(i.list);
    const e = i.list.map((l) => ({ classifyId: l.classifyId, specification: l.specification, specificationMap: l.specKV, minimumInventory: l.minimumInventory, unit: l.unitType === m.MEASURE.V ? l.measureUnit : l.accountingUnit, unitPrecision: l.unitType === m.MEASURE.V ? l.measurePrecision : l.accountingPrecision, unitType: l.unitType, workshopId: l.workshopId }));
    return await ee(e, { fields: ["minimumInventory"], toSmallest: true, toNum: true }), e;
  };
  function N() {
    p.value && p.value.clear();
  }
  function F() {
    p.value && p.value.init();
  }
  function M(i) {
    const e = { uid: oe(), sn: i.sn, classifyId: i.classify.id, classifyFullName: i.classify.fullName, specification: i.spec, specKV: i.specKV, unitType: i.classify.outboundUnitType, unitTypeDisabled: [], measureUnit: i.classify.measureUnit, accountingUnit: i.classify.accountingUnit, accountingPrecision: i.classify.accountingPrecision, measurePrecision: i.classify.measurePrecision, minimumInventory: 0, workshopId: void 0 };
    return S(e.measureUnit) && e.unitTypeDisabled.push(m.MEASURE.V), S(e.accountingUnit) && e.unitTypeDisabled.push(m.ACCOUNTING.V), e;
  }
  function P(i, e) {
    p.value.delListItem(i, e);
  }
  function z() {
    T(a.selections) && a.selections.forEach((i) => {
      i.minimumInventory = r.minimumInventory;
    });
  }
  function A() {
    T(a.selections) && a.selections.forEach((i) => {
      i.workshopId = r.workshopId;
    });
  }
  return (i, e) => {
    const l = y("common-button"), U = W, V = y("common-input-number"), c = J, O = y("common-radio-button"), D = y("common-table"), H = Q, K = y("common-dialog");
    return $(), j(K, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(a).cancelBCU, visible: v.value, title: o(a).bStatus.title, "show-close": false, fullscreen: "", "custom-class": "inventory-warning-batch-add", width: "700px", top: "10vh" }, { titleRight: s(() => [t(l, { loading: o(a).bStatus.cu === o(_).STATUS.PROCESSING, type: "primary", size: "default", onClick: o(a).submitBCU }, { default: s(() => e[3] || (e[3] = [d(" 提 交 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"]), t(te, { type: "crudBatch", onClear: N }), t(l, { size: "default", onClick: o(a).cancelBCU }, { default: s(() => e[4] || (e[4] = [d("关 闭")])), _: 1, __: [4] }, 8, ["onClick"])]), default: s(() => [b("div", le, [t(ne, { ref_key: "specRef", ref: p, class: "spec-select", modelValue: o(f).list, "onUpdate:modelValue": e[0] || (e[0] = (n) => o(f).list = n), "row-init-fn": M, "max-height": o(k) + 42 }, null, 8, ["modelValue", "max-height"]), b("div", ae, [b("div", se, [b("div", ce, [t(U, { size: "large", effect: "plain" }, { default: s(() => e[5] || (e[5] = [d("【批量】设置预警数量")])), _: 1, __: [5] }), t(V, { modelValue: r.minimumInventory, "onUpdate:modelValue": e[1] || (e[1] = (n) => r.minimumInventory = n), modelModifiers: { number: true }, min: 0, max: 999999, step: 1, precision: 3, size: "default", "controls-position": "right", placeholder: "预警数量", style: { width: "200px" } }, null, 8, ["modelValue"]), t(l, { disabled: !o(a).selections.length, type: "success", size: "default", onClick: z }, { default: s(() => e[6] || (e[6] = [d(" 设置 ")])), _: 1, __: [6] }, 8, ["disabled"])]), b("div", ue, [t(U, { size: "large", effect: "plain" }, { default: s(() => e[7] || (e[7] = [d("【批量】设置车间")])), _: 1, __: [7] }), t(I, { modelValue: r.workshopId, "onUpdate:modelValue": e[2] || (e[2] = (n) => r.workshopId = n), placeholder: "可选择车间", clearable: "" }, null, 8, ["modelValue"]), t(l, { disabled: !o(a).selections.length, type: "success", size: "default", onClick: A }, { default: s(() => e[8] || (e[8] = [d(" 设置 ")])), _: 1, __: [8] }, 8, ["disabled"])])]), t(H, { ref_key: "formRef", ref: g, model: o(f), disabled: o(a).bStatus.cu === o(_).STATUS.PROCESSING }, { default: s(() => [t(D, { ref_key: "tableRef", ref: w, border: "", data: o(f).list, "return-source-data": "", "show-empty-symbol": false, "max-height": o(k), "cell-class-name": o(E), onSelectionChange: o(a).selectionChangeHandler, "row-key": "uid" }, { default: s(() => [t(c, { type: "selection", width: "55", align: "center" }), t(c, { label: "序号", type: "index", align: "center", width: "60" }), t(c, { key: "classifyFullName", "show-overflow-tooltip": true, prop: "classifyFullName", label: "科目", align: "left", "min-width": "200" }), t(c, { key: "specification", "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "left", "min-width": "200" }), t(c, { key: "unitType", "show-overflow-tooltip": true, prop: "unitType", label: "单位配置", align: "center", width: "140" }, { default: s(({ row: n }) => [t(O, { modelValue: n.unitType, "onUpdate:modelValue": (u) => n.unitType = u, options: o(m).ENUM, "disabled-val": n.unitTypeDisabled, type: "enum", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled-val"])]), _: 1 }), t(c, { key: "unit", "show-overflow-tooltip": true, prop: "unit", label: "单位", align: "center", width: "70" }, { default: s(({ row: n }) => [d(q(n.unitType === o(m).MEASURE.V ? n.measureUnit : n.accountingUnit), 1)]), _: 1 }), t(c, { key: "minimumInventory", "show-overflow-tooltip": true, prop: "minimumInventory", label: "数量", align: "center", "min-width": "120" }, { default: s(({ row: n }) => [t(V, { modelValue: n.minimumInventory, "onUpdate:modelValue": (u) => n.minimumInventory = u, min: 0, max: 999999, step: 1, precision: n.unitType === o(m).MEASURE.V ? n.measurePrecision : n.accountingPrecision, size: "default", "controls-position": "right", style: { width: "100%", "max-width": "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), t(c, { key: "workshopId", prop: "workshopId", label: "车间", align: "center", "min-width": "160" }, { default: s(({ row: n }) => [t(I, { modelValue: n.workshopId, "onUpdate:modelValue": (u) => n.workshopId = u, placeholder: "可选择车间", clearable: "", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "operate", "show-overflow-tooltip": true, prop: "operate", label: "操作", align: "center", width: "70" }, { default: s(({ row: n, $index: u }) => [t(l, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (re) => P(n.sn, u) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "onSelectionChange"])]), _: 1 }, 8, ["model", "disabled"])])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, _e = X(de, [["__scopeId", "data-v-f68449c8"]]);
export {
  _e as default
};
