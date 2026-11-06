import { ref as c } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as m } from "vue";
import { createCommentVNode as T } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { unref as f } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElCascader as I } from "element-plus";
import { ElInput as L } from "element-plus";
import { _ as U, i as d, aw as D, es as q } from "../../../../../shared/runtime.js";
const M = { key: 0, style: { color: "red", "font-size": "12px", "margin-top": "5px" } }, $ = { __name: "type-detail", props: { data: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 }, artifactTypeConfig: { type: Array, default: () => [] }, configList: { type: Array, default: () => [] } }, setup(i, { expose: w }) {
  const n = i;
  c(false);
  const h = c(), x = c([]);
  function g(t) {
    const e = n.configList.find((a) => a.id === (t == null ? void 0 : t.newStructureClassId));
    t.newName = void 0, t.newSpecPrefix = void 0, t.namePrefixDTOS = (e == null ? void 0 : e.namePrefixDTOS) || [], t.specPrefixList = (e == null ? void 0 : e.specPrefixList.map((a) => ({ specPrefix: a }))) || [], t.artifactTypeEnumVal = e == null ? void 0 : e.artifactTypeEnumVal;
  }
  const y = { newSpecPrefix: [{ required: true, message: "请选择截面", trigger: "change" }], newName: [{ validator: (t, e) => d(e.namePrefixDTOS) ? !!t : true, message: "请选择名称", trigger: "change" }], newSpecification: [{ required: true, message: "请选择输入新规格", trigger: "blur" }], newStructureClassId: [{ required: true, message: "请选择构件类型", trigger: "change" }] }, _ = /* @__PURE__ */ new Map([["newStructureClassId", -1], ["newName", -1], ["newSpecPrefix", -1], ["artifactTypeEnumVal", -1], ["newSpecification", "同上"]]), { tableValidate: b, cleanUpData: S, wrongCellMask: v } = D({ rules: y, ditto: _, errorMsg: "请修正表格中标红的信息" });
  function N() {
    if (!d(n.data)) return true;
    const { validResult: t } = b(n.data);
    return t && (S(n.data), n.data.map((e) => (e.artifactTypeEnumVal === q.SMALL.V && (e.newName || (e.newName = e.oldName)), e))), t;
  }
  return w({ validate: N }), (t, e) => {
    const a = E, C = I, P = p("common-select"), k = L, V = p("common-table");
    return u(), m("div", null, [i.data.length > 0 ? (u(), m("div", M, "*提示：以下构件系统未识别到构件类型，请对构件类型进行定义")) : T("", true), o(V, { ref_key: "serialNumberRef", ref: h, data: n.data, "max-height": i.maxHeight - 80, "cell-class-name": f(v), "return-source-data": "", showEmptySymbol: false, style: { margin: "5px 0" } }, { default: s(() => [o(a, { type: "index", label: "序号", align: "center", width: "80" }), o(a, { key: "oldName", prop: "oldName", "show-overflow-tooltip": "", label: "名称" }), o(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号" }), o(a, { key: "oldSpecification", prop: "oldSpecification", "show-overflow-tooltip": "", label: "原规格", "min-width": "120" }), o(a, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "left", "min-width": "90px" }), o(a, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "left", "min-width": "90px" }), o(a, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", "min-width": "120" }), o(a, { key: "newStructureClassId", prop: "newStructureClassId", "show-overflow-tooltip": "", label: "构件定义类型", align: "left", "min-width": "150px" }, { default: s((l) => [o(C, { ref: (r) => x.value[t.$index] = r, modelValue: l.row.newStructureClassId, "onUpdate:modelValue": (r) => l.row.newStructureClassId = r, options: i.artifactTypeConfig, props: { value: "id", label: "classificationName", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": true, filterable: "", clearable: "", placeholder: l.$index === 0 ? "请选择构件定义类型" : "同上", onChange: (r) => g(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])]), _: 1 }), o(a, { key: "newSpecPrefix", prop: "newSpecPrefix", "show-overflow-tooltip": "", label: "截面", align: "left", "min-width": "90px" }, { default: s((l) => [o(P, { modelValue: l.row.newSpecPrefix, "onUpdate:modelValue": (r) => l.row.newSpecPrefix = r, options: l.row.specPrefixList, disabled: !f(d)(l.row.specPrefixList), "show-extra": l.$index !== 0, type: "other", filterable: "", clearable: "", dataStructure: { key: "id", label: "specPrefix", value: "specPrefix" }, placeholder: "截面" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "show-extra"])]), _: 1 }), o(a, { key: "newSpecification", prop: "newSpecification", "show-overflow-tooltip": "", label: "新规格", "min-width": "120" }, { default: s((l) => [o(k, { modelValue: l.row.newSpecification, "onUpdate:modelValue": (r) => l.row.newSpecification = r, modelModifiers: { trim: true }, "show-extra": l.$index !== 0, placeholder: "例如:400*200*10*12", type: "text", maxlength: 30 }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]);
  };
} }, O = U($, [["__scopeId", "data-v-c92c6738"]]);
export {
  O as default
};
