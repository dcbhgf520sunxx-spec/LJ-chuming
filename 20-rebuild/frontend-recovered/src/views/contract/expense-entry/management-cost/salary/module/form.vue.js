import { ref as b } from "vue";
import { computed as R } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as c } from "vue";
import { createBlock as q } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as p } from "vue";
import { withDirectives as I } from "vue";
import { createElementBlock as C } from "vue";
import { Fragment as N } from "vue";
import { renderList as D } from "vue";
import { toDisplayString as Q } from "vue";
import { createCommentVNode as A } from "vue";
import { ElFormItem as B } from "element-plus";
import { ElInputNumber as W } from "element-plus";
import { ElForm as j } from "element-plus";
import { t as z, ao as H, S as K, L as P } from "../../../../../../shared/runtime.js";
import { _ as L } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
const $ = { style: { float: "right" } }, G = { class: "form" }, Y = { __name: "form", props: { query: { type: Object } }, setup(V) {
  const { decimalPrecision: k } = z(), f = V, _ = b(), w = { id: void 0, month: void 0, employeeQuantity: void 0, attachmentFiles: [], totalWage: void 0 }, h = b([]);
  for (let s = 1; s <= 12; s++) h.value.push({ id: s, name: s });
  const F = R(() => o.status.edit > 0), { crud: o, form: t, CRUD: i } = H(w, _), T = { month: [{ required: true, message: "请选择月份", trigger: "blur" }], employeeQuantity: [{ required: true, message: "请输入员工总额", trigger: "blur" }], totalWage: [{ required: true, message: "请输入工资总额", trigger: "blur" }] };
  return i.HOOK.beforeToAdd = (s, a) => {
    s.form.attachmentIds = void 0;
  }, i.HOOK.beforeToQuery = async () => {
  }, i.HOOK.beforeToEdit = () => {
    o.form.attachmentIds = o.form.attachments ? o.form.attachments.map((s) => s.id) : void 0;
  }, i.HOOK.beforeSubmit = async () => {
    t.wageType = f.query.wageType, t.year = f.query.year, o.form.attachmentIds = o.form.attachmentFiles ? o.form.attachmentFiles.map((s) => s.id) : o.form.attachmentIds;
  }, (s, a) => {
    const y = u("common-button"), x = u("common-select-v2"), d = B, g = W, O = j, U = u("common-dialog"), E = S("show-thousand");
    return c(), q(U, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: n(() => [v("span", $, [l(y, { loading: e(o).status.cu === e(i).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(o).submitCU }, { default: n(() => a[4] || (a[4] = [p(" 提 交 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"]), l(y, { size: "default", onClick: e(o).cancelCU }, { default: n(() => a[5] || (a[5] = [p("关 闭")])), _: 1, __: [5] }, 8, ["onClick"])])]), default: n(() => [v("div", G, [l(O, { ref_key: "formRef", ref: _, model: e(t), rules: T, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [l(d, { label: "月份：", prop: "month" }, { default: n(() => [l(x, { modelValue: e(t).month, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(t).month = r), options: h.value, type: "other", placeholder: "请选择月份", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, disabled: F.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(d, { label: "员工人数：", prop: "employeeQuantity" }, { default: n(() => [I(l(g, { modelValue: e(t).employeeQuantity, "onUpdate:modelValue": a[1] || (a[1] = (r) => e(t).employeeQuantity = r), style: { width: "270px" }, placeholder: "输入员工人数", "controls-position": "right", min: 0, max: 9999999999 }, null, 8, ["modelValue"]), [[E]])]), _: 1 }), l(d, { label: "工资总额（元）：", prop: "totalWage" }, { default: n(() => [l(g, { modelValue: e(t).totalWage, "onUpdate:modelValue": a[2] || (a[2] = (r) => e(t).totalWage = r), style: { width: "270px" }, placeholder: "输入工资总额", "controls-position": "right", precision: e(k).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(d, { label: "附件：", prop: "attachments" }, { default: n(() => {
      var r;
      return [l(e(L), { ref: "uploadRef", files: e(t).attachmentFiles, "onUpdate:files": a[3] || (a[3] = (m) => e(t).attachmentFiles = m), "file-classify": e(K).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "file-classify"]), ((r = e(t).attachments) == null ? void 0 : r.length) > 0 && (!e(t).attachmentFiles || e(t).attachmentFiles.length === 0) ? (c(true), C(N, { key: 0 }, D(e(t).attachments, (m) => (c(), C("div", { key: m.id }, [p(Q(m.name) + " ", 1), l(P, { params: { id: m.id } }, null, 8, ["params"])]))), 128)) : A("", true)];
    }), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Y as default
};
