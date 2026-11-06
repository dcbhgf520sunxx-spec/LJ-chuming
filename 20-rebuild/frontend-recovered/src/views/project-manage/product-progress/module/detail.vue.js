import { ref as b } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as n } from "vue";
import { createBlock as k } from "vue";
import { withCtx as d } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as h } from "vue";
import { createElementVNode as V } from "vue";
import { createCommentVNode as g } from "vue";
import { unref as a } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as ee } from "vue";
import { Fragment as D } from "vue";
import { isRef as te } from "vue";
import { ElTag as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElPagination as le } from "element-plus";
import { vLoading as ne } from "element-plus";
import { l as y, u as re, J as ie, o as se, D as T, kQ as m, c as O, G as ce } from "../../../../shared/runtime.js";
function ue(e) {
  return y({ module: "plan", url: "planDetail/listTracev2", method: "get", params: e });
}
function de(e) {
  return y({ module: "plan", url: "planDetail/areaArtifactComplete/detail", method: "get", params: e });
}
function pe(e) {
  return y({ module: "plan", url: "planDetail/enclosureComplete/detail", method: "get", params: e });
}
function me(e) {
  return y({ module: "plan", url: "artifact/listByCondition", method: "get", params: e });
}
function ge(e) {
  return y({ module: "plan", url: "enclosure/enclosureV2/listPage", method: "get", params: e });
}
function ye(e) {
  return y({ module: "plan", url: "planDetail/areaArtifactComplete/summary", method: "get", params: e });
}
function he(e) {
  return y({ module: "plan", url: "planDetail/enclosureComplete/summary", method: "get", params: e });
}
function fe(e) {
  return y({ module: "plan", url: "planDetail/areaArtifactComplete/process", method: "get", params: e });
}
function we(e) {
  return y({ module: "plan", url: "planDetail/enclosureComplete/process", method: "get", params: e });
}
const _e = { get: ue }, ve = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, Ce = { key: 0 }, be = { key: 1 }, ke = { key: 0 }, Pe = { key: 1 }, De = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(e, { emit: M }) {
  const q = M, f = b(), I = b([]), w = b({}), l = e, { visible: E, handleClose: B } = re({ emit: q, props: l }), { handleSizeChange: H, handleCurrentChange: W, total: A, setTotalPage: Q, queryPage: P } = ie({ fetchHook: x });
  Z(E, (c) => {
    c && (x(), l.showType === "product" && (J(), z()));
  });
  const R = b([]), G = b(), j = b(false), { maxHeight: F } = se({ mainBox: ".type-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, E), $ = b([["netWeight", ["to-fixed", T.COM_WT__KG]]]);
  async function x() {
    var r, i, u, s, t;
    if (!((r = l.detailData) != null && r.id)) return;
    let c = [];
    j.value = true;
    try {
      const { content: L = [], totalElements: N } = l.showType === "deepen" ? l.detailData.projectPlanProductCategory === m.ENCLOSURE.V ? await ge({ areaId: (i = l.detailData) == null ? void 0 : i.id, sort: "id.asc", ...P }) : await me({ areaId: (u = l.detailData) == null ? void 0 : u.id, sort: "id.asc", ...P }) : l.detailData.projectPlanProductCategory === m.ENCLOSURE.V ? await pe({ areaId: (s = l.detailData) == null ? void 0 : s.id, sort: "id.asc", processId: f.value, ...P }) : await de({ areaId: (t = l.detailData) == null ? void 0 : t.id, sort: "id.asc", processId: f.value, ...P });
      c = L, Q(N);
    } catch (L) {
      console.log("明细", L);
    } finally {
      R.value = c, j.value = false;
    }
  }
  async function J() {
    var c, r, i, u;
    if ((c = l.detailData) != null && c.id) try {
      const s = ((r = l.detailData) == null ? void 0 : r.projectPlanProductCategory) === m.ENCLOSURE.V ? await we({ areaId: (i = l.detailData) == null ? void 0 : i.id }) : await fe({ areaId: (u = l.detailData) == null ? void 0 : u.id });
      I.value = s || [];
    } catch (s) {
      console.log(s, "获取工序列表失败");
    }
  }
  async function z() {
    var c, r, i, u;
    if ((c = l.detailData) != null && c.id) try {
      const s = ((r = l.detailData) == null ? void 0 : r.projectPlanProductCategory) === m.ENCLOSURE.V ? await he({ areaId: (i = l.detailData) == null ? void 0 : i.id, processId: f.value }) : await ye({ areaId: (u = l.detailData) == null ? void 0 : u.id, processId: f.value });
      w.value = s || {};
    } catch (s) {
      console.log(s, "获取汇总失败");
    }
  }
  function K() {
    x(), z();
  }
  return (c, r) => {
    const i = ae, u = S("common-select"), s = S("print-table"), t = oe, L = S("common-table"), N = le, X = S("common-drawer"), Y = ne;
    return n(), k(X, { ref_key: "drawerRef", ref: G, title: `${e.showType === "deepen" ? "深化" : "生产"}数据详情`, "close-on-click-modal": false, modelValue: a(E), "onUpdate:modelValue": r[1] || (r[1] = (v) => te(E) ? E.value = v : null), direction: "rtl", "before-close": a(B), "custom-class": "type-detail", size: "70%" }, { titleAfter: d(() => [o(i, { type: "primary", size: "large" }, { default: d(() => {
      var v, C;
      return [U(h(`项目：${((v = e.globalProject) == null ? void 0 : v.serialNumber) + "-" + ((C = e.globalProject) == null ? void 0 : C.name)}`), 1)];
    }), _: 1 })]), titleRight: d(() => r[2] || (r[2] = [])), content: d(() => {
      var v;
      return [V("div", ve, [V("div", null, [e.showType === "product" ? (n(), k(u, { key: 0, modelValue: f.value, "onUpdate:modelValue": r[0] || (r[0] = (C) => f.value = C), options: I.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "已入库", style: { width: "200px", "margin-right": "6px" }, onChange: K }, null, 8, ["modelValue", "options"])) : g("", true), e.showType === "product" ? (n(), k(i, { key: 1, type: "primary", size: "large", plain: "" }, { default: d(() => [e.detailData.projectPlanProductCategory === a(m).ENCLOSURE.V ? (n(), p("span", Ce, "共计（张）：" + h(w.value.quantity || 0), 1)) : (n(), p("span", be, "共计（件）：" + h(w.value.quantity || 0), 1))]), _: 1 })) : g("", true), e.showType === "product" ? (n(), k(i, { key: 2, style: { "margin-left": "6px" }, type: "success", size: "large", plain: "" }, { default: d(() => [e.detailData.projectPlanProductCategory === a(m).ENCLOSURE.V ? (n(), p("span", ke, "总长（m）：" + h(w.value.totalLength ? a(O)(w.value.totalLength, "mm", "m", a(T).COM_L__M) : 0), 1)) : (n(), p("span", Pe, "总净重（kg）：" + h(w.value.totalNetWeight || 0), 1))]), _: 1 })) : g("", true), e.showType === "product" && e.detailData.projectPlanProductCategory !== a(m).ENCLOSURE.V ? (n(), k(i, { key: 3, style: { "margin-left": "6px" }, type: "danger", size: "large", plain: "" }, { default: d(() => [U(" 总毛重（kg）：" + h(w.value.totalGrossWeight || 0), 1)]), _: 1 })) : g("", true)]), a(ce)(e.permission.print) ? (n(), k(s, { key: 0, "api-key": e.showType === "deepen" ? e.detailData.projectPlanProductCategory === a(m).ENCLOSURE.V ? "deepenEnclosureProcessList" : "deepenProcessList" : e.detailData.projectPlanProductCategory === a(m).ENCLOSURE.V ? "productEnclosureProcessList" : "productProcessList", params: { processId: f.value, areaId: (v = l.detailData) == null ? void 0 : v.id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])) : g("", true)]), ee((n(), k(L, { data: R.value, "data-format": $.value, "max-height": a(F) }, { default: d(() => {
        var C;
        return [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), ((C = e.detailData) == null ? void 0 : C.projectPlanProductCategory) === a(m).STRUCTURE.V ? (n(), p(D, { key: 0 }, [o(t, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), e.showType === "deepen" ? (n(), p(D, { key: 0 }, [o(t, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "netWeight", prop: "netWeight", label: "单净重(kg)", align: "center", "show-overflow-tooltip": "" })], 64)) : g("", true), e.showType === "product" ? (n(), p(D, { key: 1 }, [o(t, { key: "actualQuantity", prop: "actualQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "process.name", prop: "process.name", label: "当前工序", align: "center", "show-overflow-tooltip": "" })], 64)) : g("", true)], 64)) : (n(), p(D, { key: 1 }, [o(t, { key: "length", prop: "length", label: "单长(mm)", align: "center", "show-overflow-tooltip": "" }), e.showType === "deepen" ? (n(), p(D, { key: 0 }, [o(t, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "totalLength", prop: "totalLength", label: "总长(m)", align: "center", "show-overflow-tooltip": "" }, { default: d(({ row: _ }) => [V("span", null, h(_.totalLength ? a(O)(_.totalLength, "mm", "m", a(T).COM_L__M) : 0), 1)]), _: 1 })], 64)) : g("", true), e.showType === "product" ? (n(), p(D, { key: 1 }, [o(t, { key: "actualQuantity", prop: "actualQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "totalLength", prop: "totalLength", label: "总长(m)", align: "center", "show-overflow-tooltip": "" }, { default: d(({ row: _ }) => [V("span", null, h(_.totalLength ? a(O)(_.totalLength, "mm", "m", a(T).COM_L__M) : 0), 1)]), _: 1 }), o(t, { key: "process.name", prop: "process.name", label: "当前工序", align: "center", "show-overflow-tooltip": "" })], 64)) : g("", true)], 64))];
      }), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Y, j.value]]), o(N, { total: a(A), "current-page": a(P).pageNumber, "page-size": a(P).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(H), onCurrentChange: a(W) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Se = Object.freeze(Object.defineProperty({ __proto__: null, default: De }, Symbol.toStringTag, { value: "Module" }));
export {
  De as _,
  _e as c,
  Se as d
};
