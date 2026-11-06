import { ref as s } from "vue";
import { computed as D } from "vue";
import { watch as _e } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as A } from "vue";
import { createBlock as M } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as _ } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as x } from "vue";
import { vShow as b } from "vue";
import { createElementVNode as m } from "vue";
import { unref as w } from "vue";
import { toDisplayString as y } from "vue";
import { isRef as be } from "vue";
import { ElMessage as O } from "element-plus";
import { nextTick as q } from "vue";
import { ElFormItem as ye } from "element-plus";
import { ElInput as ke } from "element-plus";
import { ElForm as Ie } from "element-plus";
import { ElTag as Ne } from "element-plus";
import { ElTableColumn as Ve } from "element-plus";
import { vLoading as xe } from "element-plus";
import { a as Te, b as Be, d as Ce } from "../../../../../modules/feedstock-reporting-f416c9a5.js";
import { _ as je, u as De, o as Se, q as Fe, aV as Qe, i as Re, aw as ze } from "../../../../../shared/runtime.js";
import Le from "./preview.vue.js";
const Ue = { class: "my-header" }, He = { class: "input-underline" }, Ee = { style: { "margin-bottom": "18px" } }, We = { __name: "form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(G, { emit: J }) {
  const S = J, $ = G, F = s(), { visible: T, handleClose: Q } = De({ emit: S, props: $, field: "visible", showHook: de, closeHook: pe }), { maxHeight: R } = Se({ mainBox: ".feedstock-reporting-form", extraBox: [".el-dialog__header", ".my-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, F), z = { projectId: void 0 }, k = s(), P = s(), N = s([]), u = s([]), B = s(false), C = s(false), j = s(), V = s([]), L = s(), h = s(JSON.parse(JSON.stringify(z))), p = s(0), d = s({ structureType: "", monomerId: "", areaBatchName: "" }), K = D(() => {
    var a;
    return (a = L.value.map((e) => e == null ? void 0 : e.planAreaBatchDTOS)) == null ? void 0 : a.flat();
  });
  function X(a) {
    L.value = a || [];
  }
  const U = D(() => {
    const { structureType: a, monomerId: e, areaBatchId: n } = d.value || {}, c = (l, g) => (g ? (l.workshopId = l.workshopId === -1 ? void 0 : l.workshopId, l.workshopName = l.workshopName === "同上" ? void 0 : l.workshopName) : (l.workshopId = l.workshopId || -1, l.workshopName = l.workshopName || "同上"), l);
    return !a && !e && !n ? (H(), u.value) : (u.value || []).filter((l) => {
      var g;
      return (!a || ((g = l == null ? void 0 : l.structureType) == null ? void 0 : g.includes(a))) && (!e || (l == null ? void 0 : l.monomerId) === e) && (!n || (l == null ? void 0 : l.areaBatchId) === n);
    }).map((l, g) => c(l, g === 0));
  });
  function H() {
    u.value.forEach((a, e) => {
      !a.feedingQuantity && e !== 0 && (a.workshopId = -1, a.workshopName = "同上");
    });
  }
  function Y() {
    p.value--;
  }
  async function Z() {
    if (d.value.structureType = "", d.value.monomerName = "", d.value.areaBatchName = "", H(), !await k.value.validate()) return false;
    if (u.value.every((i) => !i.feedingQuantity)) {
      O.warning("至少输入一条！");
      return;
    }
    ne(u.value, W);
    const { validResult: n, dealList: c } = oe(U.value);
    if (n) u.value = c;
    else return n;
    V.value = u.value.filter((i) => i.feedingQuantity), p.value++;
  }
  function ee(a) {
    if (Re(a)) {
      const e = E.value.find((n) => n.id === a);
      j.value = (e == null ? void 0 : e.serialNumber) + "  " + (e == null ? void 0 : e.shortName);
    }
  }
  const E = D(() => {
    var e;
    return (e = N == null ? void 0 : N.value) == null ? void 0 : e.map((n) => (n.serialNumberName = n.serialNumber + " " + n.shortName, n));
  });
  async function ae() {
    try {
      const { content: a = [] } = await Te();
      N.value = a || [];
    } catch (a) {
      console.log(a);
    }
  }
  ae();
  const te = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, le = { workshopId: [{ validator: (a, e) => !(e.feedingQuantity && !e.workshopId), message: "请选择车间", trigger: "change" }] }, W = /* @__PURE__ */ new Map([["workshopId", -1], ["workshopName", "同上"]]), { tableValidate: oe, cleanUpData: ne, wrongCellMask: re } = ze({ rules: le, ditto: W });
  function se(a, e) {
    e === -1 && q(() => {
      a.workshopName = "同上";
    });
  }
  function ie(a, e) {
    e && (a.workshopName = e.name);
  }
  function ue() {
    k.value && k.value.resetFields(), h.value = JSON.parse(JSON.stringify(z)), k.value && q(() => {
      k.value.clearValidate();
    }), u.value = [], V.value = [], p.value = 0, j.value = void 0;
  }
  function de() {
    ue();
  }
  async function ce() {
    B.value = true;
    let a = [];
    const e = { projectId: h.value.projectId };
    try {
      const { content: n = [] } = await Be(e);
      n.length && (u.value = n.map((c, i) => {
        c.workshopId = i === 0 ? c.workshopId : -1, c.workshopName = i === 0 ? c.workshopName : "同上";
      })), a = n || [];
    } catch (n) {
      console.log("获取构件类别列表", n);
    } finally {
      u.value = a, B.value = false;
    }
  }
  async function me() {
    C.value = true;
    const a = { projectId: h.value.projectId, detailParamList: V.value };
    try {
      await Ce(a), O.success("保存成功"), Q(), S("success");
    } catch (e) {
      console.log("投料填报", e);
    } finally {
      C.value = false;
    }
  }
  _e(() => h.value.projectId, (a) => {
    ce();
  });
  function pe() {
  }
  return (a, e) => {
    const n = I("common-button"), c = I("common-select-v2"), i = ye, l = ke, g = Ie, fe = Ne, f = Ve, he = I("common-input-number"), ge = I("common-table"), we = I("common-dialog"), ve = xe;
    return A(), M(we, { ref_key: "dialogVisible", ref: F, title: "投料填报", modelValue: w(T), "onUpdate:modelValue": e[4] || (e[4] = (t) => be(T) ? T.value = t : null), "before-close": w(Q), "close-on-click-modal": false, top: "5vh", width: "80%", customClass: "feedstock-reporting-form" }, { titleRight: r(() => [_(o(n, { type: "warning", size: "default", onClick: Y }, { default: r(() => e[5] || (e[5] = [x(" 上一步 ")])), _: 1, __: [5] }, 512), [[b, p.value !== 0]]), _(o(n, { type: "warning", size: "default", disabled: !u.value.length, onClick: Z }, { default: r(() => e[6] || (e[6] = [x(" 下一步 ")])), _: 1, __: [6] }, 8, ["disabled"]), [[b, p.value === 0]]), _(o(n, { loading: C.value, type: "primary", size: "default", onClick: me }, { default: r(() => e[7] || (e[7] = [x(" 保存 ")])), _: 1, __: [7] }, 8, ["loading"]), [[b, p.value !== 0]])]), default: r(() => [m("div", Ue, [_(o(g, { ref_key: "formRef", ref: k, model: h.value, rules: te, inline: "", "label-position": "right", "label-width": "135px", size: "default" }, { default: r(() => [o(i, { label: "本次投料项目： ", prop: "projectId" }, { default: r(() => [m("div", He, [o(c, { modelValue: h.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (t) => h.value.projectId = t), options: E.value, size: "default", dataStructure: { key: "id", label: "serialNumberName", value: "id" }, clearable: "", filterable: "", class: "filter-item", placeholder: "选择项目", style: { width: "280px" }, onChange: ee }, null, 8, ["modelValue", "options"])])]), _: 1 }), e[8] || (e[8] = m("div", { class: "divider" }, null, -1)), o(i, { label: "单体：", class: "search-item" }, { default: r(() => [o(w(Fe), { modelValue: d.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (t) => d.value.monomerId = t), "project-id": h.value.projectId, placeholder: "可选择单体检索", clearable: "", default: false, style: { width: "200px" }, onGetAreaInfo: X }, null, 8, ["modelValue", "project-id"])]), _: 1 }), o(i, { label: "批次：", class: "search-item" }, { default: r(() => [o(c, { modelValue: d.value.areaBatchId, "onUpdate:modelValue": e[2] || (e[2] = (t) => d.value.areaBatchId = t), options: K.value, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", noDataText: d.value.monomerId ? "暂无数据" : "未选择单体", class: "filter-item", placeholder: "可选择批次检索", style: { width: "200px" } }, null, 8, ["modelValue", "options", "noDataText"])]), _: 1 }), o(i, { label: "构件类别筛选：", class: "search-item", style: { "margin-left": "20px" } }, { default: r(() => [o(l, { modelValue: d.value.structureType, "onUpdate:modelValue": e[3] || (e[3] = (t) => d.value.structureType = t), placeholder: "可输入关键字检索", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1, __: [8] }, 8, ["model"]), [[b, p.value === 0]]), _(m("div", Ee, [o(fe, { size: "large", effect: "plain" }, { default: r(() => [e[9] || (e[9] = x(" 本次投料项目: ")), m("span", null, y(j.value || "-"), 1)]), _: 1, __: [9] })], 512), [[b, p.value !== 0]])]), _((A(), M(ge, { ref_key: "tableRef", ref: P, data: U.value, "max-height": w(R), "return-source-data": "", "cell-class-name": w(re), showEmptySymbol: false, style: { width: "100%" } }, { default: r(() => [o(f, { label: "序号", type: "index", align: "center", width: "60" }), o(f, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: r((t) => [m("span", null, y(t.row.monomerName || "-"), 1)]), _: 1 }), o(f, { key: "areaBatchName", prop: "areaBatchName", "show-overflow-tooltip": "", label: "批次", align: "center" }, { default: r((t) => [m("span", null, y(t.row.areaBatchName || "-"), 1)]), _: 1 }), o(f, { key: "structureType", prop: "structureType", "show-overflow-tooltip": "", label: "构件类别", align: "center" }, { default: r((t) => [m("span", null, y(t.row.structureType || "-"), 1)]), _: 1 }), o(f, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重(kg)", align: "center" }, { default: r((t) => [m("span", null, y(t.row.totalNetWeight ?? "-"), 1)]), _: 1 }), o(f, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": "", label: "总毛重(kg)", align: "center" }, { default: r((t) => [m("span", null, y(t.row.totalGrossWeight ?? "-"), 1)]), _: 1 }), o(f, { key: "cumulativeFeedingQuantity", prop: "cumulativeFeedingQuantity", "show-overflow-tooltip": "", label: "累计已投料量(t)", align: "center" }, { default: r((t) => [m("span", null, y(t.row.cumulativeFeedingQuantity ?? "-"), 1)]), _: 1 }), o(f, { key: "feedingQuantity", prop: "feedingQuantity", "show-overflow-tooltip": "", label: "本次投料量(kg)", align: "center" }, { default: r((t) => [o(he, { modelValue: t.row.feedingQuantity, "onUpdate:modelValue": (v) => t.row.feedingQuantity = v, clearable: "", controls: false, size: "default", class: "input-border-none", placeholder: "请输入投料量" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(f, { key: "workshopId", prop: "workshopId", "show-overflow-tooltip": "", label: "生产车间", align: "center" }, { default: r((t) => [o(w(Qe), { modelValue: t.row.workshopId, "onUpdate:modelValue": (v) => t.row.workshopId = v, placeholder: "请选择生产车间", class: "input-border-none", clearable: "", "show-extra": t.$index !== 0, style: { width: "100%" }, onChange: (v) => se(t.row, v), onNameChange: (v) => ie(t.row, v) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange", "onNameChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[b, p.value === 0], [ve, B.value]]), _(o(w(Le), { previewTableData: V.value, maxHeight: w(R) }, null, 8, ["previewTableData", "maxHeight"]), [[b, p.value !== 0]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Je = je(We, [["__scopeId", "data-v-24d06e2f"]]);
export {
  Je as default
};
