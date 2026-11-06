import { ref as E } from "vue";
import { inject as j } from "vue";
import { watch as O } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as r } from "vue";
import { createBlock as s } from "vue";
import { withCtx as p } from "vue";
import { unref as e } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as h } from "vue";
import { normalizeStyle as W } from "vue";
import { isRef as D } from "vue";
import { ElNotification as z } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElDivider as U } from "element-plus";
import { s as F, b as $ } from "../../../../../../modules/productionLine-assistance-be4814e6.js";
import { u as J, o as K, rL as u } from "../../../../../../shared/runtime.js";
const ee = { __name: "assistance-preview", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(v, { emit: P }) {
  const H = P, A = v, { visible: b, handleClose: q } = J({ emit: H, props: A, field: "visible" }), { maxHeight: N } = K({ mainBox: ".assistance-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, b), I = E([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), n = j("crud"), C = E(false), k = E([]), V = E([]);
  O(() => b.value, (f) => {
    var l;
    f && (k.value = [], V.value = [], (l = A.list) == null || l.forEach((w) => {
      w.boolOneCode ? (k.value.push(w), k.value.forEach((T) => {
        var t;
        T.numbersStr = (t = T.numbersMap) == null ? void 0 : t.join("、");
      })) : V.value.push(w);
    }));
  });
  async function L() {
    try {
      C.value = true;
      const f = A.list.map((l) => ({ id: l.id, numbers: l.boolOneCode ? l.numbersMap : [], quantity: l.boolOneCode ? l.quantity : l.maxQuantity, groupsId: l.groupsId }));
      n.query.taskTypeEnum === u.MACHINE_PART.V ? await F(f) : await $(f), z({ title: "产线协同保存成功", type: "success", duration: 2500 }), q(), H("success");
    } catch (f) {
      console.log("保存产线协同报错", f);
    } finally {
      C.value = false;
    }
  }
  return (f, l) => {
    const w = G, T = M("common-button"), t = Q, R = M("common-table"), B = U, S = M("common-dialog");
    return r(), s(S, { "custom-class": "assistance-preview", "append-to-body": "", "close-on-click-modal": false, title: "产线协同预览", modelValue: e(b), "onUpdate:modelValue": l[0] || (l[0] = (o) => D(b) ? b.value = o : null), width: "1100px", "before-close": e(q) }, { titleAfter: p(() => [e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(w, { key: 0, effect: "plain" }, { default: p(() => {
      var o, c, d;
      return [x(" 原生产组：" + i((o = v.info.workshop) == null ? void 0 : o.name) + ">" + i((c = v.info.productionLine) == null ? void 0 : c.name) + ">" + i((d = v.info.groups) == null ? void 0 : d.name), 1)];
    }), _: 1 })) : m("", true)]), titleRight: p(() => [a(T, { onClick: L, loading: C.value, size: "default", type: "primary" }, { default: p(() => l[1] || (l[1] = [x("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: p(() => [h("div", { style: W(`${e(N)}px`) }, [a(R, { data: k.value, "data-format": I.value, "max-height": e(N) / 2, style: { width: "100%" } }, { default: p(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : m("", true), e(n).query.taskTypeEnum === e(u).ASSEMBLE.V ? (r(), s(t, { key: 1, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: p(({ row: o }) => [a(w, { type: o.attributeType === "部件" ? "warning" : "success" }, { default: p(() => [x(i(o.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : m("", true), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : m("", true), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : m("", true), a(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), a(t, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重", align: "center" }), a(t, { prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "总毛重", align: "center" }), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : m("", true), a(t, { prop: "numbersMap", "show-overflow-tooltip": true, label: "一物一码", width: "80", align: "center" }), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : m("", true), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: p(({ row: o }) => {
      var c, d, y;
      return [h("span", null, i((c = o.workshop) == null ? void 0 : c.name) + ">" + i((d = o.productionLine) == null ? void 0 : d.name) + ">" + i((y = o.groups) == null ? void 0 : y.name), 1)];
    }), _: 1 })) : m("", true), a(t, { prop: "groupsName", "show-overflow-tooltip": true, label: "协同产组", "min-width": "150" }, { default: p(({ row: o }) => {
      var c, d, y, g, _;
      return [h("span", null, i((d = (c = o.assistance) == null ? void 0 : c.workshop) == null ? void 0 : d.name) + ">" + i((g = (y = o.assistance) == null ? void 0 : y.productionLine) == null ? void 0 : g.name) + ">" + i((_ = o.assistance) == null ? void 0 : _.groupsName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"]), a(B, null, { default: p(() => l[2] || (l[2] = [h("span", { class: "title" }, "非一物一码", -1)])), _: 1, __: [2] }), a(R, { data: V.value, "data-format": I.value, "max-height": e(N) / 2, style: { width: "100%" } }, { default: p(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : m("", true), e(n).query.taskTypeEnum === e(u).ASSEMBLE.V ? (r(), s(t, { key: 1, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: p(({ row: o }) => [a(w, { type: o.attributeType === "部件" ? "warning" : "success" }, { default: p(() => [x(i(o.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : m("", true), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : m("", true), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : m("", true), a(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), a(t, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重", align: "center" }), a(t, { prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "总毛重", align: "center" }), e(n).query.taskTypeEnum !== e(u).MACHINE_PART.V ? (r(), s(t, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : m("", true), a(t, { prop: "maxQuantity", "show-overflow-tooltip": true, label: "协同数量", width: "80", align: "center" }), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : m("", true), e(n).query.taskTypeEnum === e(u).MACHINE_PART.V ? (r(), s(t, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: p(({ row: o }) => {
      var c, d, y;
      return [h("span", null, i((c = o.workshop) == null ? void 0 : c.name) + ">" + i((d = o.productionLine) == null ? void 0 : d.name) + ">" + i((y = o.groups) == null ? void 0 : y.name), 1)];
    }), _: 1 })) : m("", true), a(t, { prop: "groupsName", "show-overflow-tooltip": true, label: "协同产组", "min-width": "150" }, { default: p(({ row: o }) => {
      var c, d, y, g, _;
      return [h("span", null, i((d = (c = o.assistance) == null ? void 0 : c.workshop) == null ? void 0 : d.name) + ">" + i((g = (y = o.assistance) == null ? void 0 : y.productionLine) == null ? void 0 : g.name) + ">" + i((_ = o.assistance) == null ? void 0 : _.groupsName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])], 4)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
