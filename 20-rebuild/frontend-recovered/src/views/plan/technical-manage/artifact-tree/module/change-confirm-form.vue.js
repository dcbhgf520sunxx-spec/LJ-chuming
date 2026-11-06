import { ref as I } from "vue";
import { computed as z } from "vue";
import { watch as T } from "vue";
import { nextTick as q } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as V } from "vue";
import { createBlock as U } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as b } from "vue";
import { unref as p } from "vue";
import { createElementBlock as A } from "vue";
import { Fragment as K } from "vue";
import { renderList as J } from "vue";
import { isRef as O } from "vue";
import { ElFormItem as D } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElForm as H } from "element-plus";
import { ElNotification as M } from "element-plus";
import { _ as $, u as P, z as Q, R as W, S as X, i as F, tx as Y } from "../../../../../shared/runtime.js";
import { _ as Z } from "../../../../../modules/change-reason-select-73e53277.js";
import { v as ee } from "../../../../../modules/artifact-tree-bcd3b733.js";
const ae = { __name: "change-confirm-form", props: { modelValue: { type: Boolean, require: true }, confirmList: { type: Array, default: () => [] }, type: { type: [Number, String], default: void 0 }, redisKey: { type: [Number, String], default: void 0 }, areaBatchId: { type: [Number, String] } }, emits: ["success", "update:modelValue"], setup(g, { emit: L }) {
  const u = I(), n = I(JSON.parse(JSON.stringify({ changeReasonId: void 0, remark: void 0, attachments: [] }))), _ = I(false), o = g, E = z(() => {
    const i = [];
    return o.confirmList.forEach((s) => {
      s.area.forEach((t) => {
        i.findIndex((c) => c.id === t.id) < 0 && i.push(t);
      });
    }), (i.map((s) => s.name) || []).join(",");
  });
  T(() => o.modelValue, (i) => {
    i && C();
  }, { deep: true, immediate: true });
  const w = { changeReasonId: [{ required: true, message: "请选择变更原因", trigger: "change" }], remark: [{ required: true, max: 200, message: "不能超过 200 个字符", trigger: "blur" }], attachments: [{ required: true, message: "请上传附件", trigger: "change" }] }, x = L, { visible: v, handleClose: R } = P({ emit: x, props: o });
  function C() {
    u.value && u.value.resetFields(), _.value = false, u.value && q(() => {
      u.value.clearValidate();
    });
  }
  function S() {
    M({ title: "更改成功", type: "success" }), x("success"), R();
  }
  async function B(i) {
    var a, s, t, c, y;
    try {
      await u.value.validate(), _.value = true;
      let m = [], e = [];
      o.confirmList.forEach((f) => {
        if (F(f.deleteArr)) {
          const j = f.deleteArr.map((N) => ({ artifactId: N.artifactId, sortNumber: N.sortNumber }));
          m = [...m, ...j];
        }
        F(f.modifyArr) && (e = [...e, ...f.modifyArr]);
      });
      let d = { attachmentIds: n.value.attachments.map((f) => f.id) || [], changeReasonId: n.value.changeReasonId, changeScopeEnum: o.type, delArtifactList: m, monomerId: (s = (a = o.confirmList[0]) == null ? void 0 : a.monomer) == null ? void 0 : s.id, projectId: (c = (t = o.confirmList[0]) == null ? void 0 : t.project) == null ? void 0 : c.id, remark: n.value.remark, redisKey: o.redisKey, updateArtifactList: e, areaBatchId: o.areaBatchId };
      o.type === Y.AREA.V && (d = { ...d, areaId: (y = o.confirmList[0]) == null ? void 0 : y.area[0].id }), console.log(o.confirmList, d, "submitForm"), await ee(d), S();
    } catch (m) {
      console.log("构件变更", m);
    } finally {
      _.value = false;
    }
  }
  return (i, a) => {
    const s = k("common-button"), t = D, c = G, y = H, m = k("common-dialog");
    return V(), U(m, { "append-to-body": "", "close-on-click-modal": false, "before-close": p(R), modelValue: p(v), "onUpdate:modelValue": a[3] || (a[3] = (e) => O(v) ? v.value = e : null), title: "构件变更", width: "650px" }, { titleRight: r(() => [l(s, { type: "primary", size: "default", loading: _.value, onClick: B }, { default: r(() => a[4] || (a[4] = [h("确认")])), _: 1, __: [4] }, 8, ["loading"])]), default: r(() => [l(y, { ref_key: "formRef", ref: u, model: n.value, rules: w, size: "default", "label-width": "100px" }, { default: r(() => [l(t, { label: "项目" }, { default: r(() => {
      var e;
      return [h(b(p(Q)((e = g.confirmList[0]) == null ? void 0 : e.project)), 1)];
    }), _: 1 }), l(t, { label: "单体" }, { default: r(() => {
      var e, d;
      return [h(b((d = (e = g.confirmList[0]) == null ? void 0 : e.monomer) == null ? void 0 : d.name), 1)];
    }), _: 1 }), l(t, { label: "区域", prop: "specification" }, { default: r(() => [h(b(E.value), 1)]), _: 1 }), l(t, { label: "涉及编号", prop: "length" }, { default: r(() => [(V(true), A(K, null, J(g.confirmList, (e) => (V(), A("span", { key: e.id }, "【" + b(e.serialNumber) + "】", 1))), 128))]), _: 1 }), l(t, { label: "原因类型", prop: "changeReasonId" }, { default: r(() => [l(p(Z), { modelValue: n.value.changeReasonId, "onUpdate:modelValue": a[0] || (a[0] = (e) => n.value.changeReasonId = e), clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(t, { label: "描述", prop: "remark" }, { default: r(() => [l(c, { modelValue: n.value.remark, "onUpdate:modelValue": a[1] || (a[1] = (e) => n.value.remark = e), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 6 }, maxlength: 200, placeholder: "请填写原因描述", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), l(t, { label: "附件", prop: "attachments" }, { default: r(() => [l(W, { "show-download": "", "file-classify": p(X).ARTIFACT_CHANGE.V, files: n.value.attachments, "onUpdate:files": a[2] || (a[2] = (e) => n.value.attachments = e), "empty-text": "暂未上传变更附件" }, null, 8, ["file-classify", "files"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, se = $(ae, [["__scopeId", "data-v-c03a68bd"]]);
export {
  se as default
};
