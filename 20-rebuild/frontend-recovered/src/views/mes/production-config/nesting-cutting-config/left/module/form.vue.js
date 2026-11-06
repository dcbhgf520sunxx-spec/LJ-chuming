import { ref as g } from "vue";
import { watch as R } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as k } from "vue";
import { createBlock as x } from "vue";
import { withCtx as d } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createTextVNode as S } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElSwitch as N } from "element-plus";
import { ElForm as T } from "element-plus";
import { g as q } from "../../../../../../modules/nesting-cutting-config-6d0e9e39.js";
import { ao as z, aV as F, au as _ } from "../../../../../../shared/runtime.js";
import { _ as B } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const L = { __name: "form", setup(O) {
  const i = g(), p = g([]), h = { processId: void 0, workshopId: void 0, codeName: void 0, teamId: void 0, boolShowCodename: false }, { crud: a, form: t, CRUD: c } = z(h, i), b = { teamId: [{ required: true, message: "请选择班组", trigger: "blur" }], workshopId: [{ required: true, message: "请选择车间", trigger: "blur" }], codeName: [{ required: true, message: "请输入代号", trigger: "blur" }, { validator: w, trigger: "blur" }], processId: [{ required: true, message: "请选择工序", trigger: "blur" }], boolShowCodename: [{ required: true, message: "请选择是否显示代号", trigger: "change" }] };
  R(() => t.processId, () => {
    t.processId && f(t.processId);
  });
  function w(m, e, n) {
    if (!e) return n();
    /[\u4e00-\u9fa5]/.test(e) ? n(new Error("代号中不能包含中文")) : n();
  }
  async function f(m) {
    try {
      const { content: e } = await q({ processId: m, workshopId: t.workshopId });
      p.value = e;
    } catch (e) {
      console.log("获取所有班组失败", e);
    }
  }
  return c.HOOK.beforeToEdit = async () => {
    await f(t.processId);
  }, c.HOOK.beforeSubmit = () => {
    var m, e, n, s;
    t.codeRule = (m = a.data) != null && m.length ? a.data[0].codeRule : false, t.displayRule = (e = a.data) != null && e.length ? a.data[0].displayRule : false, t.teamDisplayRule = (n = a.data) != null && n.length ? (s = a.data[0]) == null ? void 0 : s.teamDisplayRule : false;
  }, (m, e) => {
    const n = u("common-button"), s = E, I = u("common-select"), V = U, y = N, v = T, C = u("common-dialog");
    return k(), x(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(a).cancelCU, visible: o(a).status.cu > 0, title: o(a).status.title, width: "520px" }, { titleRight: d(() => [l(n, { loading: o(a).status.cu === 2, type: "primary", size: "default", onClick: o(a).submitCU }, { default: d(() => e[5] || (e[5] = [S("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: d(() => [l(v, { ref_key: "formRef", ref: i, model: o(t), rules: b, size: "default", "label-width": "130px" }, { default: d(() => [l(s, { label: "车间", prop: "workshopId" }, { default: d(() => [l(o(F), { modelValue: o(t).workshopId, "onUpdate:modelValue": e[0] || (e[0] = (r) => o(t).workshopId = r), placeholder: "选择车间搜索", style: { width: "270px" }, defaultValue: "", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "工序", prop: "processId" }, { default: d(() => [l(o(B), { ref: "processSelectRef", modelValue: o(t).processId, "onUpdate:modelValue": e[1] || (e[1] = (r) => o(t).processId = r), containsMachinePart: "", size: "default", multiple: false, style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "班组", prop: "teamId" }, { default: d(() => [l(I, { modelValue: o(t).teamId, "onUpdate:modelValue": e[2] || (e[2] = (r) => o(t).teamId = r), options: p.value, type: "other", size: "default", dataStructure: { key: "id", label: "leaderName", value: "id" }, placeholder: "请选择班组", style: { width: "270px" }, disabled: !o(t).processId }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(s, { label: "代号", prop: "codeName" }, { default: d(() => [l(V, { modelValue: o(t).codeName, "onUpdate:modelValue": e[3] || (e[3] = (r) => o(t).codeName = r), maxlength: "20", placeholder: "请输入代号，中文禁止", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "是否显示代号", prop: "boolShowCodename" }, { default: d(() => [l(y, { modelValue: o(t).boolShowCodename, "onUpdate:modelValue": e[4] || (e[4] = (r) => o(t).boolShowCodename = r), "active-value": o(_).TRUE.V, "inactive-value": o(_).FALSE.V }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  L as default
};
