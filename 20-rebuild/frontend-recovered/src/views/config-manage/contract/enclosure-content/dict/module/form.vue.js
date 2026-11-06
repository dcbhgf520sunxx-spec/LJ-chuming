import { ref as C } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as U } from "vue";
import { createBlock as D } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createTextVNode as E } from "vue";
import { createElementVNode as F } from "vue";
import { toDisplayString as R } from "vue";
import { ElInput as B } from "element-plus";
import { ElFormItem as I } from "element-plus";
import { ElInputNumber as M } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as z, ao as S, aw as T } from "../../../../../../shared/runtime.js";
const O = { __name: "form", setup(Q) {
  const i = C(), p = { code: void 0, sort: void 0, dictionaryDetails: [{ id: "", name: "effectiveWidth", remark: "有效宽度(mm)", label: void 0, sort: 1 }, { id: "", name: "firstQuarter", remark: "上弦筋(φ)", label: void 0, sort: 2 }, { id: "", name: "lastQuarter", remark: "下弦筋(φ)", label: void 0, sort: 3 }, { id: "", name: "webMember", remark: "腹杆筋(φ)", label: void 0, sort: 4 }, { id: "", name: "vertical", remark: "竖向筋(φ)", label: void 0, sort: 5 }, { id: "", name: "level", remark: "水平筋(φ)", label: void 0, sort: 6 }, { id: "", name: "basementMembrane", remark: "底膜(mm)", label: void 0, sort: 7 }, { id: "", name: "weightMeter", remark: "米重(kg/m)", label: void 0, sort: 8 }] }, { CRUD: _, crud: n, form: o } = S(p, i), f = { label: [{ required: true, max: 20, message: "不能超过50个字符", trigger: "blur", type: "number" }] }, { tableValidate: b, wrongCellMask: g } = T({ rules: f }), y = { code: [{ required: true, message: "请填写编码", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], sort: [{ required: true, message: "请输入排序", trigger: "blur", type: "number" }] };
  return _.HOOK.beforeSubmit = () => {
    const { validResult: s, dealList: a } = b(o.dictionaryDetails);
    if (s) o.dictionaryDetails = a;
    else return s;
  }, (s, a) => {
    const k = d("common-button"), w = B, u = I, c = M, m = N, x = d("common-table"), h = q, V = d("common-dialog");
    return U(), D(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(n).cancelCU, visible: t(n).status.cu > 0, title: "新增", width: "500px" }, { titleRight: l(() => [e(k, { loading: t(n).status.cu === 2, type: "primary", size: "default", onClick: t(n).submitCU }, { default: l(() => a[2] || (a[2] = [E("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: l(() => [e(h, { ref_key: "formRef", ref: i, model: t(o), rules: y, size: "default", "label-width": "60px" }, { default: l(() => [e(u, { label: "编码", prop: "code" }, { default: l(() => [e(w, { modelValue: t(o).code, "onUpdate:modelValue": a[0] || (a[0] = (r) => t(o).code = r), type: "text", placeholder: "请填写编码", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), e(u, { label: "排序", prop: "sort" }, { default: l(() => [e(c, { class: "align-left", modelValue: t(o).sort, "onUpdate:modelValue": a[1] || (a[1] = (r) => t(o).sort = r), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0, max: 1e4 }, null, 8, ["modelValue"])]), _: 1 }), e(x, { data: t(o).dictionaryDetails, "empty-text": "暂无数据", "max-height": 500, "cell-class-name": t(g), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: l(() => [e(m, { label: "序号", type: "index", align: "center", width: "60" }), e(m, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "名称" }, { default: l((r) => [F("span", null, R(r.row.remark), 1)]), _: 1 }), e(m, { "show-overflow-tooltip": true, prop: "label", label: "值", align: "center" }, { default: l((r) => [e(c, { class: "align-left", modelValue: r.row.label, "onUpdate:modelValue": (v) => r.row.label = v, placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "100%" }, min: 0 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, K = z(O, [["__scopeId", "data-v-e3cf9923"]]);
export {
  K as default
};
