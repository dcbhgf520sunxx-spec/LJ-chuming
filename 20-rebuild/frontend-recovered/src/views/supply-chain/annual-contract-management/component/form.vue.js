import { ref as u } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as b } from "vue";
import { createBlock as k } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { createTextVNode as D } from "vue";
import { createElementBlock as F } from "vue";
import { Fragment as K } from "vue";
import { renderList as H } from "vue";
import { createElementVNode as A } from "vue";
import { toDisplayString as P } from "vue";
import { createCommentVNode as N } from "vue";
import { ElFormItem as J } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElForm as Q } from "element-plus";
import { _ as X } from "../../../../modules/UploadBtn-b4cfb47a.js";
import { _ as Y, ll as Z, ao as w, i as g, bE as ee, jJ as ae, S as te, L as se, iy as le, bv as oe, cP as h } from "../../../../shared/runtime.js";
const ne = ["onClick"], ie = ["onClick"], re = { __name: "form", setup(me) {
  const { loaded: I, supplierKV: U } = Z(), y = u(), V = u(), c = u(false), x = u(), B = { attachments: [], attachmentFiles: [], basicClassArr: [], basicClass: void 0, serialNumber: void 0, supplierId: void 0, timeEnd: void 0, timeStart: void 0, date: [] }, f = u([]), { CRUD: v, crud: m, form: s } = w(B, y), O = { supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }], basicClassArr: [{ required: true, message: "请选择物料分类", trigger: "change" }], date: [{ required: true, message: "请选择有效期", trigger: "change" }], serialNumber: [{ required: true, message: "请输入合同编号", trigger: "blur" }] };
  function E(e) {
    const t = e == null ? void 0 : e.basicClass;
    if (f.value = [], t) {
      const r = oe.getBits(h.ENUM, t, "K");
      for (let l = 0; l < r.length; l++) g(h.ENUM[r[l]]) && f.value.push(h.ENUM[r[l]]);
    }
  }
  v.HOOK.beforeToEdit = () => {
    const e = s.supplierId ? U.value[s.supplierId] : null;
    E(e);
  }, v.HOOK.beforeSubmit = (e, t) => {
    var r;
    if (g(e.form.date) && (e.form.timeStart = e.form.date[0], e.form.timeEnd = e.form.date[1]), g(e.form.basicClassArr)) {
      let l;
      if (e.form.basicClassArr.forEach((d) => {
        l |= d;
      }), e.form.basicClass = l, e.form.id) {
        const d = [];
        e.form.originBasicClassArr.forEach((_) => {
          e.form.basicClassArr.includes(_) || d.push(_);
        }), e.form.delBasicClassList = d;
      }
    }
    e.form.attachments = (r = e.form.attachmentFiles) == null ? void 0 : r.map((l) => l.id);
  };
  function R(e) {
    ((e == null ? void 0 : e.name.indexOf(".pdf")) > -1 || (e == null ? void 0 : e.name.indexOf(".png")) > -1 || (e == null ? void 0 : e.name.indexOf(".jpg")) > -1 || (e == null ? void 0 : e.name.indexOf(".jpeg")) > -1) && (x.value = e.id, c.value = true);
  }
  function S() {
    m.form.attachmentFiles = [], m.form.attachments = [];
  }
  function L() {
    V.value.$refs.upload.clearFiles();
  }
  return (e, t) => {
    const r = C("common-button"), l = J, d = C("common-select"), _ = W, $ = G, j = X, M = Q, T = C("common-dialog");
    return b(), k(T, { "before-close": a(m).cancelCU, "close-on-click-modal": false, title: a(m).status.title, visible: a(m).status.cu > 0, "append-to-body": "", width: "600px", onClose: L }, { titleRight: i(() => [o(r, { loading: a(m).status.cu === 2, size: "default", type: "primary", onClick: a(m).submitCU }, { default: i(() => t[6] || (t[6] = [D("确认 ")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: i(() => [o(M, { ref_key: "formRef", ref: y, model: a(s), rules: O, "label-width": "140px", size: "default" }, { default: i(() => [o(l, { label: "供应商", prop: "supplierId" }, { default: i(() => [o(ee, { modelValue: a(s).supplierId, "onUpdate:modelValue": t[0] || (t[0] = (n) => a(s).supplierId = n), mode: "contain", type: a(ae).RAW_MATERIAL.V, disabled: !a(I), style: { width: "240px" }, clearable: "", filterable: "", onInfoChange: E }, null, 8, ["modelValue", "type", "disabled"])]), _: 1 }), o(l, { label: "物料分类", prop: "basicClassArr" }, { default: i(() => [o(d, { modelValue: a(s).basicClassArr, "onUpdate:modelValue": t[1] || (t[1] = (n) => a(s).basicClassArr = n), options: f.value, type: "enum", multiple: "", clearable: "", disabled: !a(g)(f.value), placeholder: "请选择物料分类", style: { width: "240px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), o(l, { label: "有效期", prop: "date" }, { default: i(() => [o(_, { modelValue: a(s).date, "onUpdate:modelValue": t[2] || (t[2] = (n) => a(s).date = n), type: "daterange", "range-separator": ":", size: "default", class: "date-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" } }, null, 8, ["modelValue"])]), _: 1 }), o(l, { label: "创建合同号", prop: "serialNumber" }, { default: i(() => [o($, { modelValue: a(s).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (n) => a(s).serialNumber = n), type: "text", placeholder: "请填写", style: { width: "240px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), o(l, { label: "附件", prop: "attachments" }, { default: i(() => {
      var n;
      return [o(j, { ref_key: "uploadRef", ref: V, files: a(s).attachmentFiles, "onUpdate:files": t[4] || (t[4] = (p) => a(s).attachmentFiles = p), "file-classify": a(te).NORMAL.V, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "file-classify"]), ((n = a(s).attachments) == null ? void 0 : n.length) > 0 && (!a(s).attachmentFiles || a(s).attachmentFiles.length === 0) ? (b(true), F(K, { key: 0 }, H(a(s).attachments, (p, q) => (b(), F("div", { key: p.id }, [A("span", { style: { cursor: "pointer", color: "#409eff", "margin-left": "3px" }, onClick: (z) => R(p) }, P(p.name), 9, ne), o(se, { params: { id: p.id } }, null, 8, ["params"]), A("span", { onClick: (z) => S(q) }, "×", 8, ie)]))), 128)) : N("", true)];
    }), _: 1 })]), _: 1 }, 8, ["model"]), c.value ? (b(), k(le, { key: 0, isVisible: c.value, showType: "attachment", id: x.value, onClose: t[5] || (t[5] = (n) => c.value = false) }, null, 8, ["isVisible", "id"])) : N("", true)]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, ce = Y(re, [["__scopeId", "data-v-cc18da4d"]]);
export {
  ce as default
};
