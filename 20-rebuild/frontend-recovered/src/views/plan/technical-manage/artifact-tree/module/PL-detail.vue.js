import { ref as v } from "vue";
import { inject as Ae } from "vue";
import { computed as Ie } from "vue";
import { watch as N } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as a } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as w } from "vue";
import { withModifiers as X } from "vue";
import { withDirectives as Ne } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as Te } from "vue";
import { toDisplayString as Y } from "vue";
import { unref as s } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { ElRadioButton as Pe } from "element-plus";
import { ElBadge as De } from "element-plus";
import { ElRadioGroup as Ee } from "element-plus";
import { ElInput as Ue } from "element-plus";
import { ElTableColumn as Be } from "element-plus";
import { InfoFilled as Re } from "@element-plus/icons-vue";
import { ElIcon as Fe } from "element-plus";
import { ElTooltip as Qe } from "element-plus";
import { ElCascader as $e } from "element-plus";
import { ElOption as qe } from "element-plus";
import { ElSelect as ze } from "element-plus";
import { vLoading as Me } from "element-plus";
import { _ as je, a3 as te, aw as Oe, i as He } from "../../../../../shared/runtime.js";
import { u as Ge } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as Je } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as Ke } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import We from "./auto-combination.vue.js";
import Xe from "./PL-config.vue.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
import "../../../../../modules/assembly-template-config-631cc212.js";
import "../../../../../modules/artifact-tree-bcd3b733.js";
const Ye = { class: "header-style" }, Ze = { class: "screen" }, et = { style: { display: "inline-block" } }, tt = ["onDblclick"], lt = { __name: "PL-detail", props: { data: { type: Array, default: () => [] }, artifactTypeConfig: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} }, configList: { type: Array, default: () => [] }, mesProductEnum: { type: [String, Number] }, tableLoading: { type: Boolean, default: false }, boardAssembledQuantity: { type: [String, Number], default: 0 }, unBoardAssembledQuantity: { type: [String, Number], default: 0 } }, emits: ["fetchDetail"], setup(p, { expose: le, emit: ae }) {
  const x = ae, d = p, L = v(false), P = v(), ne = v(), S = v(false), _ = v(false), k = v(false), oe = Ae("fetchDetail"), o = v({ specification: void 0, minLength: void 0, maxLength: void 0, material: void 0, boolCombination: false }), ie = Ie(() => {
    let t = [];
    return t = d.configList.filter((e) => e.artifactType === 1 && e.boolComposeAssemble), t;
  }), { showDrawing: A, drawingRow: u, drawingPreview: re } = Ge({ pidField: "id", typeField: "productType" });
  function se() {
    d.data.forEach((t) => {
      t.machineSpecifications.length > 0 && (t.newSpecification = t.machineSpecifications[0].name || void 0);
    });
  }
  N([() => d.configList.length, () => d.data.length], ([t, e]) => {
    t && e && (se(), d.data.forEach((n) => {
      n.assemblyState = n.partAmendStatus, U(n);
    }));
  }, { deep: true }), N([() => S.value, () => _.value], ([t, e]) => {
    !t && !e && (A.value = false), console.log(t, e, A.value, "show");
  }), N(() => A.value, (t) => {
    var e, n, m, b;
    t && ((e = u.value) != null && e.productType && ((n = u.value) == null ? void 0 : n.productType) & te.ARTIFACT.V && (S.value = true), (m = u.value) != null && m.productType && !(((b = u.value) == null ? void 0 : b.productType) & te.ARTIFACT.V) && (_.value = true));
  });
  function ue() {
    k.value = true;
  }
  const de = { newStructureClassId: [{ required: true, message: "请选择类型", trigger: "change" }], newSpecification: [{ required: true, message: "请选择输入新规格", trigger: "change" }], newSpecPrefix: [{ required: true, message: "请选择截面", trigger: "change" }], assemblyState: [{ validator: (t, e) => !!(!e.boolComposeAssemble || e.boolComposeAssemble && e.partAmendStatus), message: "请配置部件", trigger: "change" }] }, { tableValidate: me, wrongCellMask: ce } = Oe({ rules: de, errorMsg: "请修正表格中标红的信息" });
  function D(t) {
    L.value = true, P.value = { ...t, mesProductEnum: d.mesProductEnum };
  }
  function E(t, e) {
    for (const n of t) {
      if (n.id === e) return n.classificationName;
      if (n.children && n.children.length) {
        const m = E(n.children, e);
        if (m) return m;
      }
    }
  }
  function U(t, e) {
    var m;
    const n = d.configList.find((b) => b.id === (t == null ? void 0 : t.newStructureClassId));
    t.newName = void 0, B(t), t.boolComposeAssemble || (t.newSpecification = t.oldSpecification), t.specPrefixList = (n == null ? void 0 : n.specPrefixList.map((b) => ({ specPrefix: b }))) || [], t.newSpecPrefix = e ? (m = t.specPrefixList[0]) == null ? void 0 : m.specPrefix : t.newSpecPrefix, t.artifactTypeEnumVal = n == null ? void 0 : n.artifactTypeEnumVal, t.newStructureClassLabel = E(d.artifactTypeConfig, t.newStructureClassId);
  }
  function B(t) {
    const e = d.configList.find((n) => n.id === (t == null ? void 0 : t.newStructureClassId));
    t.boolComposeAssemble = (e == null ? void 0 : e.boolComposeAssemble) || void 0;
  }
  function pe(t) {
    ne.value = t;
  }
  function fe(t, e, n) {
    console.log("row,column:", t, e);
  }
  function be() {
    if (!He(d.data)) return true;
    d.data.forEach((e) => {
      B(e);
    });
    const { validResult: t } = me(d.data);
    return t;
  }
  function ge() {
    x("fetchDetail", o.value);
  }
  function ve() {
    o.value.specification = void 0, o.value.lengthList = [], o.value.material = void 0, o.value.minLength = void 0, o.value.maxLength = void 0;
  }
  function ye() {
    o.value = { specification: void 0, lengthList: [], material: void 0, minLength: void 0, maxLength: void 0, boolCombination: false };
  }
  function I() {
    ve(), x("fetchDetail", o.value);
  }
  le({ validate: be, reset: ye });
  function he() {
    I(), oe();
  }
  return (t, e) => {
    var Q, $, q, z, M, j, O, H, G, J, K, W;
    const n = Pe, m = De, b = Ee, C = Ue, we = V("common-select"), h = V("common-button"), c = Be, xe = V("table-cell-tag"), Se = Re, _e = Fe, Ce = Qe, Ve = $e, R = qe, F = ze, Le = V("common-table"), ke = Me;
    return f(), T("div", null, [g("div", Ye, [g("div", Ze, [e[16] || (e[16] = g("div", { class: "PL-title", style: { "margin-right": "10px" } }, "PL 构件清单", -1)), a(b, { modelValue: o.value.boolCombination, "onUpdate:modelValue": e[0] || (e[0] = (l) => o.value.boolCombination = l), onChange: e[1] || (e[1] = (l) => x("fetchDetail", o.value)), class: "filter-item", style: { "margin-right": "10px" } }, { default: i(() => [a(m, { value: p.unBoardAssembledQuantity, hidden: !p.unBoardAssembledQuantity, class: "badge-item" }, { default: i(() => [a(n, { value: false }, { default: i(() => e[12] || (e[12] = [w(" 未组立 ")])), _: 1, __: [12] })]), _: 1 }, 8, ["value", "hidden"]), a(m, { value: p.boardAssembledQuantity, hidden: !p.boardAssembledQuantity, class: "badge-item" }, { default: i(() => [a(n, { class: "last-button", value: true }, { default: i(() => e[13] || (e[13] = [w(" 已组立")])), _: 1, __: [13] })]), _: 1 }, 8, ["value", "hidden"])]), _: 1 }, 8, ["modelValue"]), a(C, { modelValue: o.value.specification, "onUpdate:modelValue": e[2] || (e[2] = (l) => o.value.specification = l), placeholder: "输入规格查询", maxlength: "15", clearable: "", style: { width: "180px", "margin-right": "10px" }, oninput: "value=value.replace(/[\\u4E00-\\u9FA5]/g,'')" }, null, 8, ["modelValue"]), a(C, { modelValue: o.value.minLength, "onUpdate:modelValue": e[3] || (e[3] = (l) => o.value.minLength = l), modelModifiers: { number: true }, placeholder: "输入长度", maxlength: "15", clearable: "", type: "number", style: { width: "100px", "margin-right": "10px" } }, null, 8, ["modelValue"]), e[17] || (e[17] = g("span", { style: { "margin-right": "10px" } }, " ~ ", -1)), a(C, { modelValue: o.value.maxLength, "onUpdate:modelValue": e[4] || (e[4] = (l) => o.value.maxLength = l), modelModifiers: { number: true }, placeholder: "输入长度", maxlength: "15", clearable: "", type: "number", style: { width: "100px", "margin-right": "10px" } }, null, 8, ["modelValue"]), a(C, { modelValue: o.value.material, "onUpdate:modelValue": e[5] || (e[5] = (l) => o.value.material = l), placeholder: "输入材质查询", maxlength: "15", clearable: "", style: { width: "180px", "margin-right": "10px" }, oninput: "value=value.replace(/[\\u4E00-\\u9FA5]/g,'')" }, null, 8, ["modelValue"]), a(we, { modelValue: o.value.structureClassId, "onUpdate:modelValue": e[6] || (e[6] = (l) => o.value.structureClassId = l), options: ie.value, "data-structure": { key: "id", label: "classificationName", value: "id" }, clearable: "", type: "other", size: "default", placeholder: "选择构件类型搜索", style: { width: "180px", "margin-right": "10px" }, onChange: e[7] || (e[7] = (l) => x("fetchDetail", o.value)) }, null, 8, ["modelValue", "options"]), a(h, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: X(ge, ["stop"]) }, { default: i(() => e[14] || (e[14] = [w(" 搜索 ")])), _: 1, __: [14] }), a(h, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: X(I, ["stop"]) }, { default: i(() => e[15] || (e[15] = [w(" 重置 ")])), _: 1, __: [15] })]), a(h, { size: "default", type: "success", onClick: ue }, { default: i(() => e[18] || (e[18] = [w(" 自动组合 ")])), _: 1, __: [18] })]), Ne((f(), y(Le, { ref: "serialNumberRef", data: d.data, "max-height": p.maxHeight - 80, "cell-class-name": s(ce), "return-source-data": "", showEmptySymbol: false, style: { margin: "5px 0" }, onSelectionChange: pe, onRowDblclick: fe }, { default: i(() => [a(c, { type: "index", label: "序号", align: "center", width: "80" }), a(c, { key: "oldName", prop: "oldName", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: i((l) => [l.row.assemblyState ? (f(), y(xe, { key: 0, name: "已组合", color: "#e64242", offset: 15 })) : Te("", true), g("span", null, Y(l.row.oldName || "-"), 1)]), _: 1 }), a(c, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { header: i(() => [a(Ce, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [g("div", et, [e[19] || (e[19] = g("span", { style: { "margin-left": "10px" } }, "编号", -1)), a(_e, null, { default: i(() => [a(Se)]), _: 1 })])]), _: 1 })]), default: i((l) => [g("span", { style: { cursor: "pointer", "margin-left": "10px" }, onDblclick: (r) => s(re)(l.row) }, Y(l.row.serialNumber), 41, tt)]), _: 1 }), a(c, { key: "oldSpecification", prop: "oldSpecification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "120" }), a(c, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center", "min-width": "90px" }), a(c, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "90px" }), a(c, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", "min-width": "120" }), a(c, { key: "newStructureClassId", prop: "newStructureClassId", label: "类型", align: "center", "min-width": "200px" }, { default: i((l) => [a(Ve, { props: { value: "id", label: "classificationName", children: "children", expandTrigger: "hover", emitPath: false }, modelValue: l.row.newStructureClassId, "onUpdate:modelValue": (r) => l.row.newStructureClassId = r, options: p.artifactTypeConfig, placeholder: "请选择构件定义类型", style: { width: "270px" }, class: "filter-item", filterable: "", clearable: "", onChange: (r) => U(l.row, r) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), a(c, { key: "newSpecPrefix", prop: "newSpecPrefix", label: "截面", align: "left", "min-width": "90px" }, { default: i((l) => [a(F, { modelValue: l.row.newSpecPrefix, "onUpdate:modelValue": (r) => l.row.newSpecPrefix = r, clearable: "", filterable: "", placeholder: "请选择截面" }, { default: i(() => [(f(true), T(Z, null, ee(l.row.specPrefixList, (r) => (f(), y(R, { key: r.specPrefix, label: r.specPrefix, value: r.specPrefix }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(c, { key: "newSpecification", prop: "newSpecification", label: "新规格", "min-width": "120" }, { default: i((l) => [a(F, { modelValue: l.row.newSpecification, "onUpdate:modelValue": (r) => l.row.newSpecification = r, clearable: "", filterable: "", "allow-create": "", placeholder: "-" }, { default: i(() => [(f(true), T(Z, null, ee(l.row.machineSpecifications, (r) => (f(), y(R, { key: r.name, label: r.name, value: r.name }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(c, { label: "操作", prop: "assemblyState", align: "center", width: "120px", fixed: "right" }, { default: i((l) => [l.row.partAmendStatus ? (f(), y(h, { key: 1, size: "default", type: "primary", icon: "el-icon-edit", onClick: (r) => D(l.row), disabled: !l.row.boolComposeAssemble }, null, 8, ["onClick", "disabled"])) : (f(), y(h, { key: 0, size: "default", type: "success", icon: "el-icon-plus", onClick: (r) => D(l.row), disabled: !l.row.boolComposeAssemble }, null, 8, ["onClick", "disabled"]))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[ke, p.tableLoading]]), a(Xe, { visible: L.value, "onUpdate:visible": e[8] || (e[8] = (l) => L.value = l), rowData: P.value, onFetchAssemblyState: I }, null, 8, ["visible", "rowData"]), a(s(Je), { visible: S.value, "onUpdate:visible": e[9] || (e[9] = (l) => S.value = l), "bool-bim": (Q = s(u)) == null ? void 0 : Q.boolBim, drawingSN: ($ = s(u)) == null ? void 0 : $.drawingSN, "monomer-id": (q = s(u)) == null ? void 0 : q.monomerId, "serial-number": (z = s(u)) == null ? void 0 : z.serialNumber, productId: (M = s(u)) == null ? void 0 : M.productId, productType: (j = s(u)) == null ? void 0 : j.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType"]), a(s(Ke), { modelValue: _.value, "onUpdate:modelValue": e[10] || (e[10] = (l) => _.value = l), drawingSN: (O = s(u)) == null ? void 0 : O.drawingSN, "bool-bim": (H = s(u)) == null ? void 0 : H.boolBim, "serial-number": (G = s(u)) == null ? void 0 : G.serialNumber, productId: (J = s(u)) == null ? void 0 : J.productId, productType: (K = s(u)) == null ? void 0 : K.productType, "monomer-id": (W = s(u)) == null ? void 0 : W.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"]), a(s(We), { visible: k.value, "onUpdate:visible": e[11] || (e[11] = (l) => k.value = l), inventoryId: p.currentRow.id, onSuccess: he }, null, 8, ["visible", "inventoryId"])]);
  };
} }, wt = je(lt, [["__scopeId", "data-v-48d399de"]]);
export {
  wt as default
};
