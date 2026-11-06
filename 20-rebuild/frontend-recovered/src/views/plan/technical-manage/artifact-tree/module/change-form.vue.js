import { ref as c } from "vue";
import { watch as U } from "vue";
import { nextTick as E } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as w } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as O } from "vue";
import { isRef as z } from "vue";
import { ElMessage as B } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElInputNumber as T } from "element-plus";
import { ElForm as j } from "element-plus";
import { ElNotification as G } from "element-plus";
import { _ as J, u as K, bC as P, D as g } from "../../../../../shared/runtime.js";
import { _ as L } from "../../../../../modules/change-reason-select-73e53277.js";
import { n as $ } from "../../../../../modules/artifact-tree-bcd3b733.js";
const H = { __name: "change-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(p, { emit: M }) {
  const i = c(), v = c(false), e = c(JSON.parse(JSON.stringify({ name: void 0, quantity: void 0, changeReasonId: void 0, remark: void 0, surfaceArea: void 0, printedCode: void 0 }))), f = c(false), t = p;
  U(() => t.modelValue, (d) => {
    d && k();
  }, { deep: true, immediate: true });
  const W = { name: [{ required: true, message: "请填写名称", trigger: "blur" }], quantity: [{ validator: (d, a, s) => {
    v.value || a ? s() : s(new Error("变更后数量必须大于0"));
  }, trigger: "change" }], changeReasonId: [{ required: true, message: "请选择变更原因", trigger: "change" }], remark: [{ required: true, max: 200, message: "不能超过 200 个字符", trigger: "blur" }] }, I = M, { visible: _, handleClose: x } = K({ emit: I, props: t });
  function k() {
    i.value && i.value.resetFields(), f.value = false, e.value.name = t.detailInfo.name, e.value.quantity = t.detailInfo.quantity, e.value.netWeight = t.detailInfo.netWeight, e.value.length = t.detailInfo.length, e.value.surfaceArea = t.detailInfo.surfaceArea, e.value.printedCode = t.detailInfo.printedCode, e.value.grossWeight = t.detailInfo.grossWeight, i.value && E(() => {
      i.value.clearValidate();
    });
  }
  P(i, e);
  function R() {
    G({ title: "更改成功", type: "success" }), I("success"), x();
  }
  async function A(d) {
    try {
      if (await i.value.validate(), e.value.name === t.detailInfo.name && e.value.quantity === t.detailInfo.quantity && e.value.netWeight === t.detailInfo.netWeight && e.value.length === t.detailInfo.length && e.value.grossWeight === t.detailInfo.grossWeight && e.value.surfaceArea === t.detailInfo.surfaceArea && e.value.printedCode === t.detailInfo.printedCode) {
        B({ message: "构件信息未改动", type: "error" });
        return;
      }
      f.value = true, e.value.id = t.detailInfo.id;
      const a = { monomerId: t.query.monomerId, areaId: t.query.areaId, changeReasonId: e.value.changeReasonId, remark: e.value.remark, changeScopeEnum: 1, artifactBasicChangeDTOParam: { ...e.value, surfaceArea: Math.round(e.value.surfaceArea * 1e6) } };
      await $(a), R();
    } catch (a) {
      console.log("修改构件信息", a);
    } finally {
      f.value = false;
    }
  }
  return (d, a) => {
    const s = C("common-button"), h = D, r = S, m = T, N = j, F = C("common-dialog");
    return y(), b(F, { "append-to-body": "", "close-on-click-modal": false, "before-close": u(x), modelValue: u(_), "onUpdate:modelValue": a[9] || (a[9] = (o) => z(_) ? _.value = o : null), title: "构件变更", width: "650px" }, { titleRight: n(() => [l(s, { type: "primary", size: "default", loading: f.value, onClick: A }, { default: n(() => a[10] || (a[10] = [V("确认")])), _: 1, __: [10] }, 8, ["loading"])]), default: n(() => [l(N, { ref_key: "formRef", ref: i, model: e.value, rules: W, size: "default", "label-width": "130px" }, { default: n(() => [l(r, { label: "名称", prop: "name" }, { default: n(() => [l(h, { modelValue: e.value.name, "onUpdate:modelValue": a[0] || (a[0] = (o) => e.value.name = o), modelModifiers: { trim: true }, placeholder: "请填写名称", size: "default", clearable: "", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "编号" }, { default: n(() => [V(w(p.detailInfo.serialNumber), 1)]), _: 1 }), l(r, { label: "规格", prop: "specification" }, { default: n(() => [V(w(p.detailInfo.specification), 1)]), _: 1 }), l(r, { label: "长度(mm)", prop: "length" }, { default: n(() => [l(m, { modelValue: e.value.length, "onUpdate:modelValue": a[1] || (a[1] = (o) => e.value.length = o), modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: u(g).COM_L__MM, placeholder: "", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), v.value ? q("", true) : (y(), b(r, { key: 0, label: "数量", prop: "quantity" }, { default: n(() => [l(m, { modelValue: e.value.quantity, "onUpdate:modelValue": a[2] || (a[2] = (o) => e.value.quantity = o), modelModifiers: { number: true }, min: p.detailInfo.quantity || 0, max: d.maxNumber, step: 1, "step-strictly": "", placeholder: "", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "min", "max"])]), _: 1 })), l(r, { label: "单净重(kg)", prop: "netWeight" }, { default: n(() => [l(m, { modelValue: e.value.netWeight, "onUpdate:modelValue": a[3] || (a[3] = (o) => e.value.netWeight = o), modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: u(g).COM_WT__KG, placeholder: "单净重", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "单毛重(kg)", prop: "grossWeight" }, { default: n(() => [l(m, { modelValue: e.value.grossWeight, "onUpdate:modelValue": a[4] || (a[4] = (o) => e.value.grossWeight = o), modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: u(g).COM_WT__KG, placeholder: "单毛重", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "面积(㎡)", prop: "surfaceArea" }, { default: n(() => [l(m, { modelValue: e.value.surfaceArea, "onUpdate:modelValue": a[5] || (a[5] = (o) => e.value.surfaceArea = o), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: u(g).COM_AREA__M2, placeholder: "面积", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "喷印编码", prop: "printedCode" }, { default: n(() => [l(h, { modelValue: e.value.printedCode, "onUpdate:modelValue": a[6] || (a[6] = (o) => e.value.printedCode = o), modelModifiers: { trim: true }, placeholder: "请填写喷印编码", size: "default", clearable: "", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "原因类型", prop: "changeReasonId" }, { default: n(() => [l(u(L), { modelValue: e.value.changeReasonId, "onUpdate:modelValue": a[7] || (a[7] = (o) => e.value.changeReasonId = o), clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "原因描述", prop: "remark" }, { default: n(() => [l(h, { modelValue: e.value.remark, "onUpdate:modelValue": a[8] || (a[8] = (o) => e.value.remark = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 6 }, maxlength: 200, placeholder: "请填写原因描述", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), v.value ? (y(), b(r, { key: 1 }, { default: n(() => a[11] || (a[11] = [O("span", { class: "form-item-tip", style: { color: "red" } }, "* 提示：强制删除，未发运的构件皆可删除！请谨慎操作！", -1)])), _: 1, __: [11] })) : q("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, le = J(H, [["__scopeId", "data-v-51b2abfc"]]);
export {
  le as default
};
