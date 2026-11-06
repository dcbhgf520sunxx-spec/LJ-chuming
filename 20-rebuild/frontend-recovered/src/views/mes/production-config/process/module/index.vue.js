import { ref as M } from "vue";
import { watchEffect as f } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as E } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as V } from "vue";
import { ElTableColumn as h } from "element-plus";
import { ElCard as b } from "element-plus";
import { oZ as s, oS as o, o_ as n, cf as c } from "../../../../../shared/runtime.js";
const O = { class: "clearfix" }, H = { class: "card-title" }, w = { __name: "index", props: { data: { type: [Array, Object] }, isFixed: Boolean }, setup(T) {
  const m = T, i = M(), N = M([]), _ = ["typeName", "productCategoryType", "partProdMode"], d = {}, C = [["productCategoryType", ["parse-enum", o]], ["type", ["parse-enum", c]], ["partProdMode", ["parse-enum", n]]];
  M(false), M({});
  const u = (r, a) => {
    const e = /* @__PURE__ */ new Map();
    N.value.forEach((p) => {
      const t = a.map((y) => p[y]).join(" ");
      e.has(t) || e.set(t, []), e.get(t).push(p);
    }), m.data[r].forEach((p) => {
      const t = a.map((y) => p[y]).join(" ");
      e.has(t) && e.get(t).forEach((y) => y.name.push(`【${p.name}】`));
    });
  };
  f(() => {
    for (const r in m.data) switch (r) {
      case "artifactProcessList":
      case "assembleProcessList":
        u(r, ["productCategoryType"]);
        break;
      case "machinePartProcessList":
        u(r, ["productCategoryType", "partProdMode", "type"]);
        break;
    }
  });
  function P(r) {
    _.forEach((a) => {
      let e = 0;
      d[a] = [], r.forEach((p, t) => {
        t === 0 ? d[a].push(1) : p[a] === r[t - 1][a] ? (d[a][e] += 1, d[a].push(0)) : (e = t, d[a].push(1));
      });
    });
  }
  function A({ row: r, column: a, rowIndex: e, columnIndex: p }) {
    if (_.indexOf(a.property) !== -1) return d[a.property][e] ? [d[a.property][e], 1] : [0, 0];
  }
  return L(() => {
    N.value = [{ typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.SHEET_PART.V, partProdMode: n.ENUM.CN_CUTTING.V, type: c.ENUM.MAKINGS.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.SHEET_PART.V, partProdMode: n.ENUM.CN_CUTTING.V, type: c.ENUM.DRILL_HOLE.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.SHEET_PART.V, partProdMode: n.ENUM.AUTO_CUTTING.V, type: c.ENUM.MAKINGS.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.SHEET_PART.V, partProdMode: n.ENUM.AUTO_CUTTING.V, type: c.ENUM.DRILL_HOLE.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.PROFILE_PART.V, partProdMode: n.ENUM.CN_CUTTING.V, type: c.ENUM.MAKINGS.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.PROFILE_PART.V, partProdMode: n.ENUM.CN_CUTTING.V, type: c.ENUM.DRILL_HOLE.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.PROFILE_PART.V, partProdMode: n.ENUM.AUTO_CUTTING.V, type: c.ENUM.MAKINGS.V, name: [] }, { typeName: s.ENUM.MACHINE_PART.L, productCategoryType: o.ENUM.PROFILE_PART.V, partProdMode: n.ENUM.AUTO_CUTTING.V, type: c.ENUM.DRILL_HOLE.V, name: [] }, { typeName: s.ENUM.ASSEMBLE.L, productCategoryType: o.ENUM.WELDED_PROFILE.V, partProdMode: 99, type: 99, name: [] }, { typeName: s.ENUM.ARTIFACT.L, productCategoryType: o.ENUM.PRIMARY_SECONDARY.V, partProdMode: 66, type: 66, name: [] }], P(N.value);
  }), (r, a) => {
    const e = h, p = R("common-table"), t = b;
    return g(), I("div", null, [E(t, { shadow: "always", class: "section-config" }, { header: l(() => [U("div", O, [U("span", H, V(T.isFixed ? "固定工序库" : "灵活工序库"), 1)])]), default: l(() => [E(p, { ref_key: "tableRef", ref: i, "data-format": C, data: N.value, "span-method": A }, { default: l(() => [E(e, { key: "typeName", prop: "typeName", label: "零构件", align: "center", width: "100" }), E(e, { key: "productCategoryType", prop: "productCategoryType", label: "类型", align: "center", width: "100" }), E(e, { key: "partProdMode", prop: "partProdMode", label: "生产方式", align: "center", width: "100" }), E(e, { key: "type", prop: "type", label: "工序类", align: "center", width: "100" }), E(e, { key: "name", prop: "name", label: T.isFixed ? "必要工序分类" : "灵活工序分类", align: "left" }, null, 8, ["label"])]), _: 1 }, 8, ["data"])]), _: 1 })]);
  };
} };
export {
  w as default
};
