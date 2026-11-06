import { ref as D } from "vue";
import { inject as V } from "vue";
import { watch as K } from "vue";
import { computed as B } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as v } from "vue";
import { vShow as T } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as p } from "vue";
import { unref as c } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as $ } from "vue";
import { ElNotification as F } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElInput as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { g as Y, a as Z, m as ee, s as ae } from "./module/from.vue.js";
import te from "./module/header.vue.js";
import { _ as ne, o as ie, x as le, nl as re, c as oe, P as ue } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/coating-list-667107a8.js";
const se = { class: "herder" }, de = { key: 0 }, ce = { key: 1 }, me = { key: 1 }, ye = { key: 0 }, pe = { key: 1 }, fe = { __name: "index", props: { artifactData: { type: Object, default: () => {
} } }, setup(_) {
  const x = _, A = D(), u = D([]), { maxHeight: E } = ie({ paginate: true, extraHeight: "330px", minHeight: "300px" }), b = V("query"), P = V("getArtiList"), U = { add: true, edit: false, del: false, download: false };
  K(() => {
    var e;
    return (e = x.artifactData) == null ? void 0 : e.artifactTypeId;
  }, (e) => {
    e && r.toQuery();
  }, { deep: true });
  const { crud: r, CRUD: I } = le({ title: "工艺清单详情", sort: [], optShow: { ...U }, permission: { ...re }, crudApi: { get: Y, add: Z }, hasPagination: true, queryOnPresenterCreated: false }, A);
  function j(e, t) {
    const i = { id: e.id, monomerName: e.monomerName, areaName: e.areaName, name: e.name, serialNumber: e.serialNumber, specification: e.specification, length: e.length, material: e.material, quantity: 0, surfaceArea: 0, copyId: e.id };
    r.data.splice(t + 1, 0, i);
  }
  function H(e, t) {
    r.data.splice(t, 1), r.data.forEach((i) => {
      i.id === e.copyId && e.quantity && !i.copyId && (i.quantity += +e.quantity);
    });
  }
  function O(e) {
    u.value = e;
  }
  const h = B(() => u.value.reduce((e, t) => e + t.quantity, 0)), q = B(() => {
    const e = u.value.reduce((t, i) => t + i.surfaceArea * i.quantity, 0);
    return oe(e, "mm²", "m²");
  });
  async function Q() {
    try {
      await ae(u.value), F({ title: "无需涂装添加成功", type: "success", duration: 2500 }), P(), r.toQuery();
    } catch {
      console.log("error");
    }
  }
  function R(e, t) {
    r.data.forEach((i) => {
      i.id === e.copyId && !i.copyId && e.quantity && (e.quantity > i.quantity && (e.quantity = 1), i.quantity -= +e.quantity);
    }), e.quantityDisabled = true, e.quantity && (r.data[t].quantity = +e.quantity);
  }
  function L(e) {
    e.surfaceArea && (e.surfaceArea = +e.surfaceArea);
  }
  return I.HOOK.beforeRefresh = async (e) => {
    e.query.projectId = b.projectId, e.query.areaId = b.areaId, e.query.monomerId = b.monomerId, e.query.artifactTypeId = x.artifactData.artifactTypeId;
  }, I.HOOK.beforeToAdd = async (e, t) => {
    t.artifactList = u.value, t.artifactQuantity = h.value, t.totalArea = q.value;
  }, (e, t) => {
    var w, C;
    const i = G, f = S("common-button"), l = J, N = W, M = S("common-table"), z = X;
    return o(), m("div", null, [v(y("div", null, t[0] || (t[0] = [y("div", { class: "my-code" }, "*点击左侧构件行查看清单详情", -1)]), 512), [[T, !((w = _.artifactData) != null && w.artifactTypeId)]]), v(y("div", null, [n(i, { effect: "plain", style: { "margin-bottom": "10px" } }, { default: d(() => [k("已选数量：" + p(h.value) + "件 | 面积：" + p(q.value) + "㎡ ", 1)]), _: 1 }), y("div", se, [n(c(te)), y("div", null, [n(f, { type: "danger", disabled: !u.value.length, onClick: Q }, { default: d(() => t[1] || (t[1] = [k("无需涂装")])), _: 1, __: [1] }, 8, ["disabled"]), n(f, { type: "success", disabled: !u.value.length, onClick: c(r).toAdd }, { default: d(() => t[2] || (t[2] = [k("保存")])), _: 1, __: [2] }, 8, ["disabled", "onClick"])])]), v((o(), g(M, { ref_key: "tableRef", ref: A, data: c(r).data, "return-source-data": "", "max-height": c(E), "row-key": "id", onSelectionChange: O }, { default: d(() => [n(l, { type: "selection", width: "55", align: "center" }), n(l, { label: "序号", type: "index", align: "center", width: "60" }), n(l, { label: "单体", prop: "monomerName", key: "monomerName", align: "center" }), n(l, { label: "区域", prop: "areaName", key: "areaName", align: "center" }), n(l, { label: "名称", prop: "name", key: "name", align: "center" }), n(l, { label: "编号", prop: "serialNumber", key: "serialNumber", align: "center" }), n(l, { label: "规格", prop: "specification", key: "specification", align: "center", width: "130px" }), n(l, { label: "长度（mm）", prop: "length", key: "length", align: "center" }), n(l, { label: "材质", prop: "material", key: "material", align: "center" }), n(l, { label: "数量", prop: "quantity", key: "quantity", align: "center" }, { default: d((a) => [a.row.copyId ? (o(), m("span", de, [a.row.quantityDisabled ? (o(), m("span", ce, p(a.row.quantity), 1)) : (o(), g(N, { key: 0, modelValue: a.row.quantity, "onUpdate:modelValue": (s) => a.row.quantity = s, modelModifiers: { trim: true }, oninput: "value=value.replace(/[^\\d.]/g, '').replace(/\\./g,'')", onBlur: (s) => R(a.row, a.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]))])) : (o(), m("span", me, p(a.row.quantity), 1))]), _: 1 }), n(l, { label: "单件面积(mm²)", prop: "surfaceArea", key: "surfaceArea", align: "center", width: "120px" }, { default: d((a) => [a.row.copyId ? (o(), m("span", ye, [n(N, { modelValue: a.row.surfaceArea, "onUpdate:modelValue": (s) => a.row.surfaceArea = s, modelModifiers: { trim: true }, oninput: "value=value.replace(/[^\\d.]/g, '')", onBlur: (s) => L(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])])) : (o(), m("span", pe, p(a.row.surfaceArea || "-"), 1))]), _: 1 }), n(l, { label: "操作", prop: "wage", key: "wage", align: "center", width: "120px", fixed: "right" }, { default: d((a) => [a.row.copyId ? $("", true) : (o(), g(f, { key: 0, size: "default", type: "success", icon: "el-icon-plus", disabled: a.row.quantity <= 1, onClick: (s) => j(a.row, a.$index) }, null, 8, ["disabled", "onClick"])), a.row.copyId ? (o(), g(f, { key: 1, size: "default", type: "danger", icon: "el-icon-minus", disabled: !a.row.copyId, onClick: (s) => H(a.row, a.$index) }, null, 8, ["disabled", "onClick"])) : $("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[z, c(r).loading]]), n(c(ue))], 512), [[T, (C = _.artifactData) == null ? void 0 : C.artifactTypeId]]), n(c(ee), { selectedQuantity: h.value, selectedSurfaceArea: q.value }, null, 8, ["selectedQuantity", "selectedSurfaceArea"])]);
  };
} }, ke = ne(fe, [["__scopeId", "data-v-8135bea9"]]);
export {
  ke as default
};
