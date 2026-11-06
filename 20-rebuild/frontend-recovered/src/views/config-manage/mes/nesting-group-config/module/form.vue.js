import { ref as m } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as h } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElInput as k } from "element-plus";
import { ElForm as x } from "element-plus";
import { ao as I, fD as U, fE as v, aV as R } from "../../../../../shared/runtime.js";
import { u as E } from "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
const D = { __name: "form", setup(F) {
  const d = m(), i = m([]), p = { workshopId: void 0, teamCode: void 0, company: void 0, nestingChargePerson: void 0 }, { crud: r, form: o, CRUD: f } = I(p, d), c = { company: [{ required: true, message: "请选择单位", trigger: "change" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], teamCode: [{ required: true, message: "请输入团队码", trigger: "change" }], nestingChargePerson: [{ required: true, message: "请选择套料负责人", trigger: "change" }] };
  return f.HOOK.beforeSubmit = () => {
    o.boolDrillHole = 0;
  }, (P, l) => {
    const g = u("common-button"), s = w, _ = k, b = x, C = u("common-dialog");
    return h(), V(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "520px" }, { titleRight: a(() => [t(g, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: a(() => l[4] || (l[4] = [y("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: a(() => [t(b, { ref_key: "formRef", ref: d, model: e(o), rules: c, size: "default", "label-width": "130px" }, { default: a(() => [t(s, { label: "单位", prop: "company" }, { default: a(() => [t(U, { modelValue: e(o).company, "onUpdate:modelValue": l[0] || (l[0] = (n) => e(o).company = n), class: "filter-item", clearable: "", filterable: "", placeholder: "请选择单位", style: { width: "270px" }, "default-level": e(v).FACTORY.V }, null, 8, ["modelValue", "default-level"])]), _: 1 }), t(s, { label: "车间", prop: "workshopId" }, { default: a(() => [t(e(R), { modelValue: e(o).workshopId, "onUpdate:modelValue": l[1] || (l[1] = (n) => e(o).workshopId = n), placeholder: "选择车间搜索", style: { width: "270px" }, defaultValue: "", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "套料负责人", prop: "nestingChargePerson" }, { default: a(() => [t(e(E), { ref: "leaderSelectRef", modelValue: e(o).nestingChargePerson, "onUpdate:modelValue": l[2] || (l[2] = (n) => e(o).nestingChargePerson = n), options: i.value, size: "default", placeholder: "请选择套料负责人", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "团队编码", prop: "teamCode" }, { default: a(() => [t(_, { modelValue: e(o).teamCode, "onUpdate:modelValue": l[3] || (l[3] = (n) => e(o).teamCode = n), placeholder: "请输入套料软件团队码", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  D as default
};
