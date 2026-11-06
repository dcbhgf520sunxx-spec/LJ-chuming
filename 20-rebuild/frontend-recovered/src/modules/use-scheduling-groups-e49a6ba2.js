import { a3 as d } from "../shared/runtime.js";
import { g as w } from "./artifact-f1b0ca44.js";
async function k({ productType: o, structureClassId: e, _factoryIds: u, disabledIds: l = [] }, t = false) {
  if ((!o || !e && o !== d.MACHINE_PART.V) && !t) return { list: [], obj: {} };
  const p = await w({ productType: o, structureClassId: e }), h = o === d.MACHINE_PART.V || t;
  return L(p, u, l, h);
}
function L(o, e, u = [], l = false) {
  if (e != null && e.length || l) {
    let t = [];
    const p = {};
    for (let n = 0; n < o.length; n++) ((e == null ? void 0 : e.indexOf(o[n].id)) !== -1 || l) && (t = t.concat(o[n].workshopList));
    const h = [], m = t;
    for (let n = 0; n < m.length; n++) {
      const g = [], r = m[n].productionLineList;
      for (let i = 0; i < r.length; i++) {
        const c = [], a = r[i].groupsList;
        for (let s = 0; s < a.length; s++) c.push({ id: a[s].id, name: a[s].name, disabled: u.includes(a[s].id) }), p[a[s].id] = { productionLine: { id: r[i].id, name: r[i].name }, workshop: { id: m[n].id, name: m[n].name }, groupsName: a[s].name };
        g.push({ id: r[i].id, name: r[i].name, children: c });
      }
      h.push({ id: m[n].id, name: m[n].name, children: g });
    }
    return { list: h, obj: p };
  } else return { list: [], obj: {} };
}
export {
  k as m
};
