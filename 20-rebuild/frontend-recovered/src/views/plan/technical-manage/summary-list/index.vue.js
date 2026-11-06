import { ref as i } from "vue";
import { watch as U } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as _ } from "vue";
import { createElementVNode as m } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as d } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as g } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTag as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { l as b, _ as ee, m as te, o as oe, i as ae, G as V, tw as A, D as y } from "../../../../shared/runtime.js";
import { I as W } from "../../../../modules/plan-d12d7ccf.js";
import le from "./module/detail.vue.js";
function ne(r) {
  return b({ module: "plan", url: "product/artifact/project", method: "get", params: r });
}
function re(r) {
  return b({ module: "plan", url: "product/part/project", method: "get", params: r });
}
function ue(r) {
  return b({ module: "plan", url: "product/artifact/monomer", method: "get", params: r });
}
function ie(r) {
  return b({ module: "plan", url: "product/part/monomer", method: "get", params: r });
}
function se(r) {
  return b({ module: "plan", url: "product/project/sum", method: "get", params: r });
}
const ce = { class: "app-container" }, me = { __name: "index", setup(r) {
  const { globalProject: f } = te(["globalProject"]), G = i(), h = i([]), C = i(false), x = i(false), { maxHeight: N } = oe({ wrapperBox: ".summary-list", paginate: true, extraHeight: 40 + 34 }), s = i(), p = i(), k = i({}), S = { key: "no", label: "name", value: "no" }, I = i([{ name: "构件", no: 7 }, { name: "零件", no: 9 }]), v = i([]), D = i([]);
  async function F() {
    k.value = await se({ projectId: f.value.id, productType: s.value === 7 ? 2 : s.value === 9 ? 1 : s.value });
  }
  U(() => f.value, (o) => {
    ae(o) && (s.value = I.value.length > 0 ? I.value[0].no : void 0, E(s.value));
  }, { deep: true, immediate: true });
  function E(o) {
    if (v.value = [], p.value = void 0, o) {
      if (!V(W.get)) return;
      switch (o) {
        case 9:
          T();
          break;
        default:
          O();
          break;
      }
      F();
    }
  }
  async function O() {
    x.value = true, D.value = [];
    try {
      const { content: o } = await ne({ projectId: f.value.id, permissionCheck: A.CHECK_PERMISSION.V });
      o.length > 0 && o.forEach((e) => {
        e.monomerId = e.monomer.id, e.name = e.monomer.name;
      }), v.value = o;
    } catch (o) {
      v.value = [], console.log("获取构件清单", o);
    } finally {
      x.value = false;
    }
  }
  async function T() {
    x.value = true, D.value = [];
    try {
      const { content: o } = await re({ projectId: f.value.id, permissionCheck: A.CHECK_PERMISSION.V });
      o.length > 0 && o.forEach((e) => {
        e.monomerId = e.monomer.id, e.name = e.monomer.name;
      }), v.value = o;
    } catch (o) {
      v.value = [], console.log("获取零件清单", o);
    } finally {
      x.value = false;
    }
  }
  async function K(o) {
    try {
      const { content: e } = await ue({ projectId: f.value.id, monomerId: o });
      e.length > 0 && e.forEach((a) => {
        a.areaId = a.area.id, a.name = a.area.name, a.axis = a.area.axis;
      }), h.value = e;
    } catch (e) {
      h.value = [], console.log("获取构件单体清单", e);
    }
  }
  async function L(o) {
    try {
      const { content: e } = await ie({ projectId: f.value.id, monomerId: o });
      e.length > 0 && e.forEach((a) => {
        a.areaId = a.area.id, a.name = a.area.name, a.axis = a.area.axis;
      }), h.value = e;
    } catch (e) {
      h.value = [], console.log("获取零件单体清单", e);
    }
  }
  function R(o) {
    if (h.value = [], s.value) switch (s.value) {
      case 7:
        K(o.monomerId);
        break;
      case 9:
        L(o.monomerId);
        break;
    }
    C.value = true;
  }
  return (o, e) => {
    const a = M("common-radio-button"), B = X, u = Y, q = M("common-button"), H = M("common-table"), $ = Q("permission"), z = Z;
    return c(), J("div", ce, [_(a, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => s.value = t), options: I.value, type: "other", dataStructure: S, onChange: E, style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), m("div", null, [_(B, { size: "large", class: "filter-item", style: { "margin-bottom": "5px" } }, { default: l(() => [P(d(`总数量: ${k.value.totalQuantity || 0}
          | 总净重:${k.value.totalNetWeight || 0} KG
          | 总毛重:${k.value.totalGrossWeight || 0} KG`), 1)]), _: 1 })]), j((c(), g(H, { ref_key: "tableRef", ref: G, data: v.value, "empty-text": n(V)(n(W).get) ? "暂无数据" : "暂无权限", "max-height": n(N), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: l(() => [_(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), _(u, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "单体", width: "300px", align: "center" }, { default: l((t) => [m("span", null, d(t.row.name), 1)]), _: 1 }), _(u, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "合计数量", width: "300px", align: "center" }, { default: l((t) => [m("span", null, d(t.row.quantity), 1)]), _: 1 }), p.value ? w("", true) : (c(), g(u, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "合计毛重(kg)", width: "300px", align: "center" }, { default: l((t) => [m("span", null, d(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(n(y).COM_WT__KG) : "-"), 1)]), _: 1 })), p.value ? w("", true) : (c(), g(u, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "合计净重(kg)", width: "300px", align: "center" }, { default: l((t) => [m("span", null, d(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(n(y).COM_WT__KG) : "-"), 1)]), _: 1 })), p.value ? (c(), g(u, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": true, label: "合计量(m)", width: "300px", align: "center" }, { default: l((t) => [m("span", null, d(t.row.totalLength ? t.row.totalLength.toFixed(n(y).COM_L__M) : "-"), 1)]), _: 1 })) : w("", true), p.value ? w("", true) : (c(), g(u, { key: "totalDrawingWeight", prop: "totalDrawingWeight", "show-overflow-tooltip": true, label: "合计图纸重（kg)", width: "200px" }, { default: l((t) => [m("span", null, d(t.row.totalDrawingWeight ? t.row.totalDrawingWeight.toFixed(n(y).COM_WT__KG) : "-"), 1)]), _: 1 })), p.value ? w("", true) : (c(), g(u, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "合计面积（m²）", width: "200px" }, { default: l((t) => [m("span", null, d(t.row.totalArea ? t.row.totalArea.toFixed(n(y).COM_AREA__M2) : "-"), 1)]), _: 1 })), p.value ? w("", true) : (c(), g(u, { key: "topFlangeArea", prop: "topFlangeArea", "show-overflow-tooltip": true, label: "合计上翼缘面积（㎡）", width: "200px" }, { default: l((t) => [m("span", null, d(t.row.topFlangeArea ? t.row.topFlangeArea.toFixed(n(y).COM_AREA__M2) : "-"), 1)]), _: 1 })), _(u, { label: "操作", align: "center", fixed: "right" }, { default: l((t) => [j((c(), g(q, { size: "default", type: "primary", onClick: (de) => R(t.row) }, { default: l(() => e[2] || (e[2] = [P("查看区域详情")])), _: 2, __: [2] }, 1032, ["onClick"])), [[$, n(W).detail]])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[z, x.value]]), _(n(le), { "current-info": h.value, modelValue: C.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => C.value = t), globalProject: n(f), enclosureCategory: p.value }, null, 8, ["current-info", "modelValue", "globalProject", "enclosureCategory"])]);
  };
} }, he = ee(me, [["__scopeId", "data-v-f624fbcf"]]);
export {
  he as default
};
