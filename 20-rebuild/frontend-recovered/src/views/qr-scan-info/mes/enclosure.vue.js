import { _ as S } from "../../../modules/black-bg-05289b55.js";
import { d as T } from "../../../modules/qr-scan-info-657de68e.js";
import { useRoute as C } from "vue-router";
import { ref as n } from "vue";
import { computed as A } from "vue";
import { watchEffect as P } from "vue";
import { ElLoading as R } from "element-plus";
import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as e } from "vue";
import { unref as v } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as w } from "vue";
import { _ as j, s as D, i as m } from "../../../shared/runtime.js";
import { c as V } from "../../../modules/index-f09320a8.js";
import "../../../modules/externalRequest-4308f5b0.js";
const W = { class: "app-container" }, $ = { class: "title-drawer" }, z = { class: "subtitle" }, F = { class: "info" }, K = { class: "subtitle" }, M = { class: "info" }, O = { key: 0 }, Q = { key: 1 }, U = { class: "subtitle" }, G = { class: "info" }, H = { __name: "enclosure", setup(J) {
  const t = C(), a = n({ name: "", serialNumber: "", plateType: "", color: "", thickness: "", area: "", length: "", effectiveWidth: "" }), N = t.query.id, q = t.query.factoryId, B = t.query.taskId, _ = n(!!+t.query.sl), I = n(!!+t.query.sa), E = n(!!+t.query.sm), d = n(t.query.lang || "zh"), f = A(() => t.query.type), o = n();
  P(() => {
    d.value && f.value && (o.value = V({ productType: f.value, language: d.value }));
  });
  const x = { id: N, factoryId: q, taskId: B }, h = window.location.href.split(D.QR_SCAN_ENCLOSURE_TASK)[0].split("/#")[0];
  console.log(h), L(h, x);
  async function L(y, r) {
    const i = R.service({ lock: true, text: "正在加载围护信息", background: "rgba(0, 0, 0, 0.7)", fullscreen: true });
    try {
      const l = await T(y, r);
      a.value = l, console.log(a);
    } catch (l) {
      console.log("获取围护信息失败", l);
    } finally {
      i.close();
    }
  }
  return (y, r) => {
    var i, l, g, k, b;
    return u(), c("div", W, [r[0] || (r[0] = s("img", { src: S, class: "img-bg" }, null, -1)), s("div", $, e(`${a.value.name} ${a.value.serialNumber}`), 1), s("span", z, e(o.value("baseInfo")), 1), s("div", F, [s("span", null, e(o.value("name")) + "：" + e(a.value.name || "-"), 1), s("span", null, e(o.value("code")) + "：" + e(a.value.serialNumber || "-"), 1), s("span", null, e(o.value("plateType")) + "：" + e(a.value.plate || "-"), 1), s("span", null, e(o.value("color")) + "：" + e(a.value.color || "-"), 1), s("span", null, e(o.value("thickness")) + "：" + e(v(m)(a.value.thickness) ? a.value.thickness + " mm" : "-"), 1), s("span", null, e(o.value("length")) + "：" + e(v(m)(a.value.length) ? a.value.length + " mm" : "-"), 1), s("span", null, e(o.value("effectWidth")) + "：" + e(v(m)(a.value.width) ? a.value.width + " mm" : "-"), 1)]), s("span", K, e(o.value("usePart")), 1), s("div", M, [s("span", null, e(o.value("project")) + "：" + e(((i = a.value.project) == null ? void 0 : i.shortName) || "-"), 1), E.value ? (u(), c("span", O, e(o.value("monomer")) + "：" + e(((l = a.value.monomer) == null ? void 0 : l.name) || "-"), 1)) : p("", true), I.value ? (u(), c("span", Q, e(o.value("region")) + "：" + e(((g = a.value.area) == null ? void 0 : g.name) || "-"), 1)) : p("", true)]), _.value ? (u(), c(w, { key: 0 }, [s("span", U, e(o.value("productionInfo")), 1), s("div", G, [_.value ? (u(), c(w, { key: 0 }, [s("span", null, e(o.value("factory")) + "：" + e(((k = a.value.factory) == null ? void 0 : k.name) || "-"), 1), s("span", null, e(o.value("productionLine")) + "：" + e(((b = a.value.productionLine) == null ? void 0 : b.name) || "-"), 1)], 64)) : p("", true)])], 64)) : p("", true)]);
  };
} }, oe = j(H, [["__scopeId", "data-v-a5821c9f"]]);
export {
  oe as default
};
