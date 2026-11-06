import { ref as m } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as D } from "vue";
import { withModifiers as Q } from "vue";
import { createCommentVNode as W } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as n } from "vue";
import { unref as p } from "vue";
import { normalizeStyle as E } from "vue";
import { withDirectives as X } from "vue";
import { Fragment as Y } from "vue";
import { renderList as Z } from "vue";
import { isRef as ee } from "vue";
import { ElTag as te } from "element-plus";
import { ElDescriptionsItem as ae } from "element-plus";
import { ElDescriptions as le } from "element-plus";
import { ElCard as se } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElCol as ie } from "element-plus";
import { ElRow as ne } from "element-plus";
import { vLoading as re } from "element-plus";
import { l as j, _ as ce, u as de, o as ue, p as R } from "../../../../../shared/runtime.js";
import me from "../../quality-problem-statistics/module/detail.vue.js";
function fe(h) {
  return j({ url: "/api/mes/building/paintThickness/check/page", method: "get", params: h });
}
function pe(h) {
  return j({ url: "/api/mes/building/paintThickness/check/detail", method: "get", params: h });
}
const Te = { get: fe };
const _e = { class: "head-container" }, he = { style: { float: "right" } }, ve = { class: "custom-list" }, be = { style: { "font-weight": "bolder" } }, ge = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible", "detailClose"], setup(h, { emit: L }) {
  const z = m(), O = m(), w = m(false), x = m(false), g = m([]), V = m({}), N = m(), B = m(), o = m({}), T = m([]), $ = L, M = h, { visible: k, handleClose: A } = de({ emit: $, props: M, field: "visible", showHook: I }), { maxHeight: C } = ue({ mainBox: ".film-thick-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, extraHeight: 100, navbar: false, clientHRepMainH: true }, k);
  async function I() {
    T.value = [{ id: 1, name: "本次检测漆膜厚度合理范围", thick: void 0, bgColor: "#f2f2f2" }, { id: 2, name: "平均厚度", thick: void 0, bgColor: "#fff0ab" }, { id: 3, name: "最小厚度", thick: void 0, bgColor: "#cadfff" }, { id: 4, name: "最大厚度", thick: void 0, bgColor: "#cadfff" }], await U();
  }
  async function U() {
    var f, i, v, c;
    w.value = true;
    try {
      const l = await pe({ id: (f = M.detailData) == null ? void 0 : f.id });
      o.value = l || {}, g.value = (l == null ? void 0 : l.paintThicknessDTOList) || [], (i = g.value) == null || i.forEach((r) => {
        r.thickness >= (l == null ? void 0 : l.minThickness) && r.thickness <= (l == null ? void 0 : l.maxThickness) ? r.isRange = true : r.isRange = false;
      });
      const b = (v = g.value) == null ? void 0 : v.map((r) => r.thickness);
      N.value = Math.min(...b), B.value = Math.max(...b), (c = T.value) == null || c.forEach((r) => {
        switch (r.name) {
          case "本次检测漆膜厚度合理范围":
            r.thick = (l == null ? void 0 : l.minThickness) + " μm ~ " + (l == null ? void 0 : l.maxThickness) + " μm";
            return;
          case "平均厚度":
            r.thick = (l == null ? void 0 : l.avgThickness) + " μm";
            return;
          case "最小厚度":
            r.thick = N.value + " μm";
            return;
          case "最大厚度":
            r.thick = B.value + " μm";
            return;
        }
      });
    } catch (l) {
      console.log(l, "获取检测点的列表数据失败");
    } finally {
      w.value = false;
    }
  }
  function q() {
    var f;
    V.value = ((f = o.value) == null ? void 0 : f.qhseDTO) || {}, x.value = true;
  }
  function F({ row: f, rowIndex: i }) {
    if (f.isRange === false) return { background: "#fadada" };
  }
  return (f, i) => {
    const v = te, c = ae, l = le, b = se, r = oe, P = S("common-table"), H = ie, G = ne, J = S("common-drawer"), K = re;
    return _(), y(J, { ref_key: "drawerRef", ref: z, title: "漆膜厚度详情", modelValue: p(k), "onUpdate:modelValue": i[1] || (i[1] = (e) => ee(k) ? k.value = e : null), "close-on-click-modal": false, direction: "rtl", "before-close": p(A), "custom-class": "film-thick-detail", size: "50%" }, { titleRight: t(() => i[2] || (i[2] = [])), content: t(() => [u("div", _e, [s(b, { shadow: "always" }, { header: t(() => {
      var e, a;
      return [u("div", null, [i[5] || (i[5] = u("span", { class: "card-title" }, "构件工序信息", -1)), u("div", he, [((e = o.value) == null ? void 0 : e.boolAdoptEnum) === false ? (_(), D("span", { key: 0, class: "tc-primary problem-report", onClick: Q(q, ["stop"]) }, " 点击查看质检问题报告 ")) : W("", true), ((a = o.value) == null ? void 0 : a.boolAdoptEnum) === false ? (_(), y(v, { key: 1, style: { "margin-left": "6px" }, size: "large", type: "danger" }, { default: t(() => i[3] || (i[3] = [d("质检结果：不合格")])), _: 1, __: [3] })) : (_(), y(v, { key: 2, style: { "margin-left": "6px" }, size: "large", type: "success" }, { default: t(() => i[4] || (i[4] = [d("质检结果：合格")])), _: 1, __: [4] }))])])];
    }), default: t(() => [s(l, { column: 2 }, { default: t(() => [s(c, { label: "编号" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.project) == null ? void 0 : a.serialNumber) || "-"), 1)];
    }), _: 1 }), s(c, { label: "生产线" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.productionLine) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), s(c, { label: "编码" }, { default: t(() => {
      var e;
      return [d(n(((e = o.value) == null ? void 0 : e.number) || "-"), 1)];
    }), _: 1 }), s(c, { label: "班组" }, { default: t(() => {
      var e;
      return [d(n(((e = o.value) == null ? void 0 : e.teamUserName) || "-"), 1)];
    }), _: 1 }), s(c, { label: "项目" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.project) == null ? void 0 : a.shortName) || "-"), 1)];
    }), _: 1 }), s(c, { label: "上报人" }, { default: t(() => {
      var e;
      return [d(n(((e = o.value) == null ? void 0 : e.reporterName) || "-"), 1)];
    }), _: 1 }), s(c, { label: "单体" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.monomer) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), s(c, { label: "上报时间" }, { default: t(() => {
      var e, a;
      return [d(n((e = o.value) != null && e.reportTime ? p(R)((a = o.value) == null ? void 0 : a.reportTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)];
    }), _: 1 }), s(c, { label: "区域" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.area) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), s(c, { label: "质检人" }, { default: t(() => {
      var e;
      return [d(n(((e = o.value) == null ? void 0 : e.inspectionName) || "-"), 1)];
    }), _: 1 }), s(c, { label: "工序" }, { default: t(() => {
      var e, a;
      return [d(n(((a = (e = o.value) == null ? void 0 : e.process) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), s(c, { label: "质检时间" }, { default: t(() => {
      var e, a;
      return [d(n((e = o.value) != null && e.reportTime2 ? p(R)((a = o.value) == null ? void 0 : a.reportTime2, "{y}-{m}-{d} {h}:{i}") : "-"), 1)];
    }), _: 1 })]), _: 1 })]), _: 1 })]), u("div", { style: E(`margin-top: 20px;height: ${p(C)}px`) }, [s(b, { shadow: "always" }, { header: t(() => i[6] || (i[6] = [u("span", { class: "card-title" }, "检测点", -1)])), default: t(() => [s(G, { gutter: 20 }, { default: t(() => [s(H, { xs: 24, sm: 24, md: 14, lg: 14 }, { default: t(() => [X((_(), y(P, { ref_key: "tableRef", ref: O, data: g.value, "empty-text": "暂无数据", "max-height": p(C), "row-key": "name", stripe: false, border: false, "row-style": F, style: { width: "100%" } }, { default: t(() => [s(r, { "show-overflow-tooltip": true, align: "center", prop: "name", label: "点", width: "100px" }, { default: t(({ row: e }) => [u("span", null, n(e.name || "-"), 1)]), _: 1 }), s(r, { "show-overflow-tooltip": true, align: "center", prop: "thickness", label: "厚度（μm）" }, { default: t(({ row: e }) => [u("span", null, n(e.thickness || "-"), 1)]), _: 1 }), s(r, { "show-overflow-tooltip": true, align: "center", prop: "detectionTime", label: "时间" }, { default: t(({ row: e }) => [u("span", null, n(e.detectionTime ? p(R)(e.detectionTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[K, w.value]])]), _: 1 }), s(H, { xs: 24, sm: 24, md: 10, lg: 10 }, { default: t(() => [u("div", { style: E(`height: ${p(C)}px;margin-top: 10px`) }, [(_(true), D(Y, null, Z(T.value, (e) => (_(), D("div", { key: e.id, style: E(`background-color: ${e.bgColor}; border-radius: 10px;`) }, [u("div", ve, [u("div", null, n(e.name), 1), u("div", be, n(e.thick), 1)])], 4))), 128))], 4)]), _: 1 })]), _: 1 })]), _: 1 })], 4), s(p(me), { visible: x.value, "onUpdate:visible": i[0] || (i[0] = (e) => x.value = e), "detail-data": V.value, onDetailClose: f.detailClose }, null, 8, ["visible", "detail-data", "onDetailClose"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ke = ce(ge, [["__scopeId", "data-v-645a54c9"]]), Ce = Object.freeze(Object.defineProperty({ __proto__: null, default: ke }, Symbol.toStringTag, { value: "Module" }));
export {
  Ce as a,
  Te as c,
  ke as d
};
