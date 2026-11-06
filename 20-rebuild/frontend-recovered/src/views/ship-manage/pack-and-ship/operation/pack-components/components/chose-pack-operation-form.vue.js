import { inject as R } from "vue";
import { ref as d } from "vue";
import { reactive as b } from "vue";
import { openBlock as i } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { unref as u } from "vue";
import { ElRadioGroup as E } from "element-plus";
import { createTextVNode as p } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElRadioButton as S } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElForm as D } from "element-plus";
import { _ as T } from "../../../../../../modules/index-828ab502.js";
import { m as O } from "../../../../../../modules/manuf-warehouse-select-bae65ecc.js";
import "../../../../../../shared/runtime.js";
const $ = { __name: "chose-pack-operation-form", props: { visible: { type: Boolean, default: false }, workshopId: { type: [Number, String], default: void 0 }, packLoading: { type: Boolean, default: false }, packType: { type: Number, default: void 0 }, typeVal: { type: Number } }, emits: ["selectBagIdChange, isNewChange"], setup(f, { expose: N, emit: V }) {
  const c = V, y = R("projectId"), I = d(), g = d(), e = b({ isNew: 2, serialNumber: "" }), w = d([]), k = b({ isNew: [{ required: true, message: "请选择新增方式", trigger: "change" }], selectBagId: [{ required: true, message: "请选择原有包单", trigger: "change" }], serialNumber: [{ required: true, message: "请输入包单号", trigger: "blur" }, { min: 2, max: 10, message: "长度为2~10个字符", trigger: "blur" }] });
  async function h() {
    return { valid: await g.value.validate(), ...e };
  }
  function B() {
    e.isNew = 2, e.serialNumber = "", e.warehouseId = void 0, e.selectBagId = void 0;
  }
  function C(o) {
    w.value = o || [];
  }
  function v(o) {
    const a = w.value.find((s) => s.id === o) || {};
    c("selectBagIdChange", a);
  }
  function x(o) {
    c("isNewChange", o);
  }
  return N({ validForm: h, initForm: B }), (o, a) => {
    const s = S, n = U, F = q, j = D;
    return i(), m(j, { ref_key: "ruleFormRef", ref: g, model: e, rules: k, "label-width": "auto", inline: "" }, { default: l(() => [t(n, { label: "选择新增方式", prop: "isNew" }, { default: l(() => [t(u(E), { modelValue: e.isNew, "onUpdate:modelValue": a[0] || (a[0] = (r) => e.isNew = r), onChange: x }, { default: l(() => [t(s, { label: 2 }, { default: l(() => a[4] || (a[4] = [p("自动生成新包单")])), _: 1, __: [4] }), t(s, { label: 1 }, { default: l(() => a[5] || (a[5] = [p("手动输入新包单")])), _: 1, __: [5] }), t(s, { label: 0 }, { default: l(() => a[6] || (a[6] = [p("使用原有包单")])), _: 1, __: [6] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), e.isNew === 1 ? (i(), m(n, { key: 0, label: "手动输入包单号", prop: "serialNumber" }, { default: l(() => [t(F, { modelValue: e.serialNumber, "onUpdate:modelValue": a[1] || (a[1] = (r) => e.serialNumber = r), placeholder: "请输入", clearable: "", style: { width: "240px" } }, null, 8, ["modelValue"])]), _: 1 })) : _("", true), e.isNew ? _("", true) : (i(), m(n, { key: 1, label: "选择原有包单", prop: "selectBagId" }, { default: l(() => [t(u(T), { ref_key: "packSelectRef", ref: I, modelValue: e.selectBagId, "onUpdate:modelValue": a[2] || (a[2] = (r) => e.selectBagId = r), "project-id": u(y), typeVal: f.typeVal, style: { width: "240px" }, onFetchData: C, onChange: v }, null, 8, ["modelValue", "project-id", "typeVal"])]), _: 1 })), t(n, { label: "选择存放位置", prop: "warehouseId" }, { default: l(() => [t(u(O), { modelValue: e.warehouseId, "onUpdate:modelValue": a[3] || (a[3] = (r) => e.warehouseId = r), "workshop-id": f.workshopId, clearable: "", style: { width: "240px" } }, null, 8, ["modelValue", "workshop-id"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"]);
  };
} };
export {
  $ as default
};
