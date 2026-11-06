import { ref as y } from "vue";
import { computed as p } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as z } from "vue";
import { withDirectives as L } from "vue";
import { vShow as O } from "vue";
import { unref as a } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as u } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as H } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as k } from "vue";
import { ElInput as Q } from "element-plus";
import { ElPopconfirm as R } from "element-plus";
import { _ as j, B as Z, aa as G, tl as K, C as J, G as w, L as W, tg as X, E as Y } from "../../../../../../../../shared/runtime.js";
import { r as g } from "../../../../../../../../modules/plan-d12d7ccf.js";
const ee = { class: "row-wrap blue" }, ae = { style: { color: "#0d84ff" } }, le = { class: "row-wrap warning" }, te = { __name: "header", props: { selectedIds: { type: Array, default: () => [] } }, emits: ["clear"], setup(I, { expose: h, emit: x }) {
  const f = I, D = { projectId: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, dataType: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, steelPlateTypeEnum: { value: void 0, resetAble: false }, sign: void 0, serialNumber: void 0, userName: void 0 }, { crud: t, query: r } = Z(D), V = x, d = y([{ id: 1, format: ".pdf", name: "生产图纸(PDF)" }, { id: 2, format: ".pdf", name: "焊缝地图(PDF)" }, { id: 3, format: ".mark", name: "焊缝(MARK)" }]), m = y(d.value[0].id), s = y(1), C = p(() => {
    var l;
    return (l = d.value.find((e) => e.id === m.value)) == null ? void 0 : l.format;
  }), E = p(() => s.value === 1 ? !f.selectedIds.length : false);
  p(() => t.query.productType === G.MACHINE_PART.V ? [d.value[1].id, d.value[2].id] : []);
  const A = p(() => {
    let l = "weldIds";
    return m.value === d.value[0].id && (l = "drawingID"), l;
  }), P = p(() => {
    let l = "图纸";
    return m.value === d.value[1].id ? l = "焊缝地图" : m.value === d.value[2].id && (l = "焊缝"), [{ id: 1, key: 1, name: `选中清单的${l}` }, { id: 2, key: 2, name: `列表中所有的${l}` }, { id: 3, key: 3, name: `清单${l}匹配状态` }];
  });
  async function S() {
    const l = f.selectedIds.map((e) => e == null ? void 0 : e[A.value]).flat();
    try {
      await t.crudApi.del({ ids: l }), t.notify("操作成功", "success"), t.toQuery(), V("clear");
    } catch (e) {
      console.log(e);
    }
  }
  async function F() {
    await t.ref.table.clearSelection(), V("clear");
  }
  function U() {
    m.value = d.value[0].id;
  }
  return h({ delIdField: A, uploadType: m, uploadFormat: C, initUploadType: U, uploadTypeOptions: d }), (l, e) => {
    const q = _("common-radio-button"), N = Q, B = _("common-radio"), M = _("common-button"), $ = R;
    return b(), z("div", null, [L(i("div", null, [u(q, { modelValue: a(r).sign, "onUpdate:modelValue": e[0] || (e[0] = (o) => a(r).sign = o), optionAllValue: void 0, options: a(K).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: a(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), u(N, { modelValue: a(r).serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (o) => a(r).serialNumber = o), class: "filter-item", clearable: "", placeholder: "编号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), u(N, { modelValue: a(r).userName, "onUpdate:modelValue": e[2] || (e[2] = (o) => a(r).userName = o), class: "filter-item", clearable: "", placeholder: "操作人", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), u(a(J))], 512), [[O, a(t).searchToggle]]), u(a(Y), null, { optLeft: c(() => {
      var o;
      return [i("div", ee, [i("div", { class: "pointer", onClick: F }, "点击清空选中"), i("div", null, [e[4] || (e[4] = v(" 当前选中 ")), i("span", ae, H(((o = f.selectedIds) == null ? void 0 : o.length) + "条"), 1), e[5] || (e[5] = v(" 记录 "))])])];
    }), viewLeft: c(() => {
      var o;
      return [i("div", le, [e[7] || (e[7] = i("div", { style: { width: "150px" } }, "选择下载内容", -1)), u(B, { modelValue: s.value, "onUpdate:modelValue": e[3] || (e[3] = (n) => s.value = n), options: P.value, style: { "--radio-color": "#e6a23c" }, type: "other" }, null, 8, ["modelValue", "options"]), (s.value === 3 ? a(w)(a(g).download) : a(w)(a(g).drawingZipDownload)) ? (b(), T(W, { key: 0, disabled: E.value, fn: s.value === 3 ? a(t).crudApi.fileMatchingDetailsDownload : a(X), params: { ...a(r), serialNumbers: s.value === 1 ? f.selectedIds.map((n) => n.serialNumber) : void 0, taskTypeEnum: s.value === 3 ? void 0 : a(t).query.productType, areaId: s.value.value === 1 ? (o = Array.from(new Set(a(t).data.map((n) => n.areaId)))) != null && o.length ? Array.from(new Set(a(t).data.map((n) => n.areaId)))[0] : a(t).query.areaId : void 0 }, "response-header-result": true, boolDrawing: "", icon: "" }, { default: c(() => e[6] || (e[6] = [v(" 点击下载 ")])), _: 1, __: [6] }, 8, ["disabled", "fn", "params"])) : k("", true)]), a(w)(a(g).del) ? (b(), T($, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定解除匹配吗?", onConfirm: S }, { reference: c(() => {
        var n;
        return [u(M, { disabled: ((n = I.selectedIds) == null ? void 0 : n.length) <= 1, size: "default", type: "danger" }, { default: c(() => e[8] || (e[8] = [v(" 批量: 解除匹配 ")])), _: 1, __: [8] }, 8, ["disabled"])];
      }), _: 1 })) : k("", true)];
    }), _: 1 })]);
  };
} }, se = j(te, [["__scopeId", "data-v-f3264842"]]);
export {
  se as default
};
