import { ref as i } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as V } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { unref as r } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as j } from "vue";
import { createVNode as s } from "vue";
import { isRef as C } from "vue";
import { ElMessage as R } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElForm as W } from "element-plus";
import { a as q } from "../../../../../modules/bid-list-077bf24b.js";
import { u as z, lI as T, G as A, dH as D } from "../../../../../shared/runtime.js";
import { _ as O } from "../../../../../modules/region-cascader-39b54da2.js";
const J = { __name: "add-form", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, tenderType: { type: Number, default: void 0 }, crmSpecialBubmissionStatusEnum: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(f, { emit: w }) {
  const m = f, g = w, { visible: d, handleClose: v } = z({ emit: g, props: m, showHook: E, closeHook: k }), c = i(false), n = i(), a = i({}), y = i([]), h = { projectName: [{ required: true, message: "请填写项目名称", trigger: "change" }], crmEnterpriseWarehousingId: [{ required: true, message: "请选择招标单位", trigger: "change" }], regionList: [{ required: true, message: "请选择国省市区", trigger: "change" }] };
  async function E() {
    var t;
    (t = n.value) == null || t.clearValidate(), await x();
  }
  async function x() {
    try {
      const t = await T();
      y.value = t || [];
    } catch (t) {
      console.log(t, "获取招标单位列表失败");
    }
  }
  async function k() {
    var t, e;
    await ((t = n.value) == null ? void 0 : t.resetFields()), await ((e = n.value) == null ? void 0 : e.clearValidate());
  }
  async function N() {
    if (await n.value.validate()) try {
      c.value = true, await q({ ...a.value, crmSpecialBubmissionStatusEnum: m.crmSpecialBubmissionStatusEnum }) && (R.success("保存成功"), g("success"), v());
    } catch (e) {
      console.log(e, "保存失败");
    } finally {
      c.value = false;
    }
  }
  return (t, e) => {
    const S = p("common-button"), b = U, u = H, I = p("common-select-v2"), B = W, F = p("common-drawer");
    return V(), _(F, { modelValue: r(d), "onUpdate:modelValue": e[4] || (e[4] = (o) => C(d) ? d.value = o : null), "before-close": r(v), "close-on-click-modal": false, size: "25%", title: `新增任务（${r(D).VL[m.crmSpecialBubmissionStatusEnum]}）` }, { titleAfter: l(() => e[5] || (e[5] = [])), titleRight: l(() => [r(A)(f.permission.save) ? (V(), _(S, { key: 0, type: "success", loading: c.value, onClick: N }, { default: l(() => e[6] || (e[6] = [L(" 保存 ")])), _: 1, __: [6] }, 8, ["loading"])) : j("", true)]), content: l(() => [s(B, { ref_key: "contentFormRef", ref: n, size: "default", model: a.value, rules: h, "label-width": "90px" }, { default: l(() => [s(u, { label: "项目名称", prop: "projectName" }, { default: l(() => [s(b, { modelValue: a.value.projectName, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.projectName = o), type: "text", maxlength: "50", placeholder: "填写项目名称", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 }), s(u, { label: "招标单位", prop: "crmEnterpriseWarehousingId" }, { default: l(() => [s(I, { modelValue: a.value.crmEnterpriseWarehousingId, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.crmEnterpriseWarehousingId = o), options: y.value, filterable: "", clearable: "", dataStructure: { value: "id", label: "businessName", key: "id" }, type: "other", placeholder: "请选择招标单位", style: { width: "300px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), s(u, { label: "国省市区", prop: "regionList" }, { default: l(() => [s(r(O), { style: { width: "300px" }, clearable: "", modelValue: a.value.regionList, "onUpdate:modelValue": e[2] || (e[2] = (o) => a.value.regionList = o), placeholder: "选择国省市区" }, null, 8, ["modelValue"])]), _: 1 }), s(u, { label: "详细地址", prop: "address" }, { default: l(() => [s(b, { modelValue: a.value.address, "onUpdate:modelValue": e[3] || (e[3] = (o) => a.value.address = o), type: "text", maxlength: "50", placeholder: "填写详细地址", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} };
export {
  J as default
};
